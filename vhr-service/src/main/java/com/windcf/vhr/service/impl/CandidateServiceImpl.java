package com.windcf.vhr.service.impl;

import com.windcf.vhr.common.enums.GenderEnum;
import com.windcf.vhr.common.enums.UserTypeEnum;
import com.windcf.vhr.common.exception.FileException;
import com.windcf.vhr.common.exception.VhrException;
import com.windcf.vhr.common.util.JwtTokenUtil;
import com.windcf.vhr.mapper.CandidateMapper;
import com.windcf.vhr.model.entity.Candidate;
import com.windcf.vhr.model.form.*;
import com.windcf.vhr.model.query.CandidateQuery;
import com.windcf.vhr.model.vo.AbstractUserInfoVo;
import com.windcf.vhr.model.vo.CandidateInfoVo;
import com.windcf.vhr.model.vo.LoginResultVo;
import com.windcf.vhr.security.exception.AuthenticationException;
import com.windcf.vhr.service.CandidateService;
import com.windcf.vhr.service.FileService;
import com.windcf.vhr.service.UserService;
import com.windcf.vhr.service.VerificationCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

/**
 * @author chunf
 * @time 2022-09-16 9:28
 * @package com.windcf.vhr.service.impl
 * @description cand service impl
 */
@Service
@Slf4j
public class CandidateServiceImpl implements CandidateService {
    private final FileService fileService;
    private final CandidateMapper candidateMapper;
    private final VerificationCodeService verificationCodeService;

    private final UserService userService;

    public CandidateServiceImpl(FileService fileService, CandidateMapper candidateMapper, VerificationCodeService verificationCodeService, UserService userService) {
        this.fileService = fileService;
        this.candidateMapper = candidateMapper;
        this.verificationCodeService = verificationCodeService;
        this.userService = userService;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public LoginResultVo loginByEmail(EmailPwdLoginFormPwd form) {
        CandidateQuery query = CandidateQuery.builder().candEmail(form.getEmail()).candPwd(DigestUtils.md5DigestAsHex(form.getPassword().getBytes(StandardCharsets.UTF_8))).build();
        Candidate candidate = candidateMapper.selectByExample(query);

        if (candidate == null) {
            throw new AuthenticationException("账号或密码错误！");
        }

        Candidate updCand = Candidate.builder().candId(candidate.getCandId()).candLastLogin(LocalDateTime.now()).build();
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
    public boolean phoneExists(String phone) {
        CandidateQuery query = CandidateQuery.builder().candPhone(phone).build();
        Candidate candidate = candidateMapper.selectByExample(query);
        return candidate != null;
    }

    /**
     * TODO 不必都查出来
     */
    @Override
    public boolean idCardExists(String idCard) {
        CandidateQuery query = CandidateQuery.builder().candIdCard(idCard).build();
        return candidateMapper.selectByExample(query) != null;
    }

    @Override
    public AbstractUserInfoVo getCandInfo(Long candId) {
        return new CandidateInfoVo(candidateMapper.selectByPrimaryKey(candId));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean modifyPwd(ModifyCandPwdForm form) {
        Candidate candidate = candidateMapper.selectByPrimaryKey(form.getCandId());
        /*
        unexpected
         */
        if (candidate == null) {
            throw new AuthenticationException("参数错误!");
        }

        if (!candidate.getCandPwd().equals(DigestUtils.md5DigestAsHex(form.getOldPwd().getBytes(StandardCharsets.UTF_8)))) {
            throw new AuthenticationException("旧密码错误!");
        }

        Candidate updCand = Candidate.builder().candPwd(DigestUtils.md5DigestAsHex(form.getNewPwd().getBytes(StandardCharsets.UTF_8))).candId(form.getCandId()).build();
        return candidateMapper.updateByPrimaryKey(updCand) == 1;
    }

    @Override
    public boolean updateCand(UpdateCandForm form) {
        Candidate candidate = Candidate.builder().candId(form.getCandId()).candName(form.getUsername()).candLiving(form.getLiving()).candHometown(form.getHometown()).candHeavy(form.getHeavy()).candNation(form.getNation()).candHeight(form.getHeight()).candPolitic(form.getPolitic()).candVisionLeft(form.getVisionLeft()).candVisionRight(form.getVisionRight()).build();
        return candidateMapper.updateByPrimaryKeySelective(candidate) == 1;
    }

    @Override
    public boolean updateCandEmail(UpdateCandEmailForm form) {
        verificationCodeService.validateEmailCode(form.getEmail(), form.getCode());
        Long candId = userService.getCurrentCandId();
        Candidate candidate = Candidate.builder().candId(candId).candEmail(form.getEmail()).build();
        return candidateMapper.updateByPrimaryKeySelective(candidate) == 1;
    }

    @Override
    public URI updateAvatar(MultipartFile file) {
        URI uri = fileService.uploadAvatar(file);
        Long candId = userService.getCurrentCandId();
        if (candId == null) {
            throw new AuthenticationException("请求异常");
        }
        Candidate candidate = candidateMapper.selectByPrimaryKey(candId);
        if (!fileService.remove(candidate.getCandAvatar())) {
            log.warn(String.format("删除文件 %s 失败", candidate.getCandAvatar()));
            throw new FileException("删除原文件失败!请稍后重试");
        }
        Candidate udpCand = Candidate.builder().candId(candId).candAvatar(uri.toString()).build();
        if (candidateMapper.updateByPrimaryKeySelective(udpCand) == 1) {
            return uri;
        }
        throw new VhrException("更新头像失败!");
    }


    @Override
    public LoginResultVo loginByEmailCode(EmailCodeLoginForm form) {
        verificationCodeService.validateEmailCode(form.getEmail(), form.getCode());
        Candidate candidate = candidateMapper.selectByExample(CandidateQuery.builder().candEmail(form.getEmail()).build());
        Candidate updCand = Candidate.builder().candId(candidate.getCandId()).candLastLogin(LocalDateTime.now()).build();
        candidateMapper.updateByPrimaryKeySelective(updCand);
        return buildLoginResult(candidate);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public CandidateInfoVo register(RegisterForm form) {
        verificationCodeService.validateEmailCode(form.getEmail(), form.getEmailCode());
        if (emailExists(form.getEmail())) {
            throw new AuthenticationException("邮箱已存在");
        }
        if (phoneExists(form.getPhone())) {
            throw new AuthenticationException("手机号已存在");
        }
        if (idCardExists(form.getIdCard())) {
            throw new AuthenticationException("身份证号已存在");
        }
        GenderEnum genderEnum = Integer.parseInt(form.getIdCard().substring(16, 17)) % 2 == 1 ? GenderEnum.M : GenderEnum.F;
        Candidate candidate = Candidate.builder().candEmail(form.getEmail()).candPwd(DigestUtils.md5DigestAsHex(form.getPassword().getBytes(StandardCharsets.UTF_8))).candIdCard(form.getIdCard()).candName(form.getUsername()).candGender(genderEnum.name()).candPhone(form.getPhone()).build();
        candidateMapper.insertSelective(candidate);
        return new CandidateInfoVo(candidate);
    }

    private LoginResultVo buildLoginResult(Candidate candidate) {
        String token = JwtTokenUtil.generateToken(candidate.getCandId(), candidate.getCandName(), UserTypeEnum.CANDIDATE.name());
        CandidateInfoVo candidateInfoVo = new CandidateInfoVo(candidate);
        return new LoginResultVo(token, candidateInfoVo);
    }
}
