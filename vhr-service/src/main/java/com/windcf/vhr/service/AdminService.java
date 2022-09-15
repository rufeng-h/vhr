package com.windcf.vhr.service;

import com.windcf.vhr.model.form.AdminPhoneLoginForm;
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
     * login by phone
     *
     * @param form loginForm
     * @return loginresult
     * @throws AuthenticationException authenticate error
     */
    @NonNull
    LoginResultVo login(AdminPhoneLoginForm form) throws AuthenticationException;
}
