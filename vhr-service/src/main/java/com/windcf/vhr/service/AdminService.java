package com.windcf.vhr.service;

import com.windcf.vhr.model.form.EmailCodeLoginForm;
import com.windcf.vhr.model.form.EmailPwdLoginFormPwd;
import com.windcf.vhr.model.vo.AbstractUserInfoVo;
import com.windcf.vhr.model.vo.LoginResultVo;
import com.windcf.vhr.security.exception.AuthenticationException;
import org.springframework.lang.NonNull;

/**
 * @author chunf
 * @time 2022-09-15 14:57
 * @package com.windcf.vhr.service
 * @description admin service
 */
public interface AdminService {
    /**
     * loginByEmail by phone
     *
     * @param form loginForm
     * @return loginresult
     * @throws AuthenticationException authenticate error
     */
    @NonNull
    LoginResultVo loginByEmail(EmailPwdLoginFormPwd form) throws AuthenticationException;

    /**
     * check email exists
     *
     * @param email email
     * @return email exists
     */
    boolean emailExists(String email);

    LoginResultVo loginByEmailCode(EmailCodeLoginForm form);

    AbstractUserInfoVo getUserInfo(Long userId);
}
