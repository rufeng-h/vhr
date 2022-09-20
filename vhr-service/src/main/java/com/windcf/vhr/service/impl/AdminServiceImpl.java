package com.windcf.vhr.service.impl;

import com.windcf.vhr.common.enums.UserTypeEnum;
import com.windcf.vhr.common.util.JwtTokenUtil;
import com.windcf.vhr.mapper.AdminMapper;
import com.windcf.vhr.model.entity.Admin;
import com.windcf.vhr.model.form.EmailCodeLoginForm;
import com.windcf.vhr.model.form.EmailPwdLoginFormPwd;
import com.windcf.vhr.model.query.AdminQuery;
import com.windcf.vhr.model.vo.AbstractUserInfoVo;
import com.windcf.vhr.model.vo.AdminInfoVo;
import com.windcf.vhr.model.vo.LoginResultVo;
import com.windcf.vhr.security.exception.AuthenticationException;
import com.windcf.vhr.service.AdminService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

/**
 * @author chunf
 * @time 2022-09-15 15:00
 * @package com.windcf.vhr.service.impl
 * @description admin service impl
 */
@Service
public class AdminServiceImpl implements AdminService {
    private final StringRedisTemplate stringRedisTemplate;
    private final AdminMapper adminMapper;

    public AdminServiceImpl(StringRedisTemplate stringRedisTemplate, AdminMapper adminMapper) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.adminMapper = adminMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LoginResultVo loginByEmail(EmailPwdLoginFormPwd form) throws AuthenticationException {
        AdminQuery query = AdminQuery.builder().adminEmail(form.getEmail()).adminPwd(DigestUtils.md5DigestAsHex(form.getPassword().getBytes(StandardCharsets.UTF_8))).build();
        Admin admin = adminMapper.selectByExample(query);
        if (admin == null) {
            throw new AuthenticationException("账号或密码错误");
        }

        Admin updAdmin = Admin.builder().adminId(admin.getAdminId()).adminLastLogin(LocalDateTime.now()).build();
        adminMapper.updateByPrimaryKeySelective(updAdmin);

        return buildLoginResult(admin);
    }

    @Override
    public boolean emailExists(String email) {
        AdminQuery query = AdminQuery.builder().adminEmail(email).build();
        return adminMapper.selectByExample(query) != null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LoginResultVo loginByEmailCode(EmailCodeLoginForm form) {
        String code = stringRedisTemplate.opsForValue().get(form.getEmail());
        if (!form.getCode().equals(code)) {
            throw new AuthenticationException("验证码错误或不存在！");
        }
        Admin admin = adminMapper.selectByExample(AdminQuery.builder().adminEmail(form.getEmail()).build());
        Admin updAdmin = Admin.builder().adminId(admin.getAdminId()).adminLastLogin(LocalDateTime.now()).build();
        adminMapper.updateByPrimaryKeySelective(updAdmin);
        return buildLoginResult(admin);
    }

    @Override
    public AbstractUserInfoVo getUserInfo(Long adminId) {
        return new AdminInfoVo(adminMapper.selectByPrimaryKey(adminId));
    }

    private LoginResultVo buildLoginResult(Admin admin) {
        String token = JwtTokenUtil.generateToken(admin.getAdminId(), admin.getAdminName(), UserTypeEnum.ADMIN.name());

        AdminInfoVo adminInfoVo = new AdminInfoVo(admin);

        return new LoginResultVo(token, adminInfoVo);
    }
}
