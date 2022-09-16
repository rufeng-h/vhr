package com.windcf.vhr.service.impl;

import com.windcf.vhr.common.enums.UserTypeEnum;
import com.windcf.vhr.common.util.JwtTokenUtil;
import com.windcf.vhr.mapper.CandidateMapper;
import com.windcf.vhr.model.entity.Candidate;
import com.windcf.vhr.model.form.EmailCodeLoginForm;
import com.windcf.vhr.model.form.EmailPwdLoginFormPwd;
import com.windcf.vhr.model.query.CandidateQuery;
import com.windcf.vhr.model.vo.CandidateInfoVo;
import com.windcf.vhr.model.vo.LoginResultVo;
import com.windcf.vhr.security.exception.AuthenticationException;
import com.windcf.vhr.service.CandidateService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

/**
 * @author chunf
 * @time 2022-09-16 9:28
 * @package com.windcf.vhr.service.impl
 * @description cand service impl
 */
@Service
public class CandidateServiceImpl implements CandidateService {
    private final CandidateMapper candidateMapper;
    private final StringRedisTemplate stringRedisTemplate;

    public CandidateServiceImpl(CandidateMapper candidateMapper, StringRedisTemplate stringRedisTemplate) {
        this.candidateMapper = candidateMapper;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public LoginResultVo loginByEmail(EmailPwdLoginFormPwd form) {
        CandidateQuery query = CandidateQuery.builder()
                .candEmail(form.getEmail())
                .candPwd(DigestUtils.md5DigestAsHex(form.getPassword().getBytes(StandardCharsets.UTF_8))).build();
        Candidate candidate = candidateMapper.selectByExample(query);

        if (candidate == null) {
            throw new AuthenticationException("账号或密码错误！");
        }

        Candidate updCand = Candidate.builder().candId(candidate.getCandId())
                .candLastLogin(LocalDateTime.now()).build();
        candidateMapper.updateByPrimaryKeySelective(updCand);

        return buildLoginResult(candidate);
    }

    @Override
    public boolean emailExists(String email) {
        CandidateQuery query = CandidateQuery.builder().candEmail(email).build();
        Candidate candidate = candidateMapper.selectByExample(query);
        return candidate != null;
    }

    @Override
    public LoginResultVo loginByEmailCode(EmailCodeLoginForm form) {
        String code = stringRedisTemplate.opsForValue().get(form.getEmail());
        if (!form.getCode().equals(code)){
            throw new AuthenticationException("验证码错误或不存在!");
        }
        Candidate candidate = candidateMapper.selectByExample(CandidateQuery.builder().candEmail(form.getEmail()).build());
        Candidate updCand = Candidate.builder().candId(candidate.getCandId())
                .candLastLogin(LocalDateTime.now()).build();
        candidateMapper.updateByPrimaryKeySelective(updCand);
        return buildLoginResult(candidate);
    }

    private LoginResultVo buildLoginResult(Candidate candidate){
        String token = JwtTokenUtil.generateToken(candidate.getCandId(), candidate.getCandName(), UserTypeEnum.CANDIDATE.name());
        CandidateInfoVo candidateInfoVo = new CandidateInfoVo(candidate);
        return new LoginResultVo(token, candidateInfoVo);
    }
}
