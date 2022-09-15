package com.windcf.vhr.service.impl;

import com.windcf.vhr.common.enums.UserTypeEnum;
import com.windcf.vhr.common.util.JwtTokenUtil;
import com.windcf.vhr.mapper.AdminMapper;
import com.windcf.vhr.model.entity.Admin;
import com.windcf.vhr.model.form.AdminPhoneLoginForm;
import com.windcf.vhr.model.query.AdminQuery;
import com.windcf.vhr.model.vo.LoginResultVo;
import com.windcf.vhr.security.exception.AuthenticationException;
import com.windcf.vhr.service.AdminService;
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
    private final AdminMapper adminMapper;

    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LoginResultVo login(AdminPhoneLoginForm form) throws AuthenticationException {
        AdminQuery query = AdminQuery.builder()
                .adminPhone(form.getAdminPhone())
                .adminPwd(DigestUtils.md5DigestAsHex(form.getAdminPwd().getBytes(StandardCharsets.UTF_8)))
                .build();
        Admin admin = adminMapper.selectByExample(query);
        if (admin == null) {
            throw new AuthenticationException("账号或密码错误");
        }

        Admin updAdmin = Admin.builder().adminId(admin.getAdminId()).adminLastLogin(LocalDateTime.now()).build();
        adminMapper.updateByPrimaryKeySelective(updAdmin);

        String token = JwtTokenUtil.generateToken(admin.getAdminId(), admin.getAdminName(), UserTypeEnum.ADMIN.name());
        return new LoginResultVo(token);
    }
}
