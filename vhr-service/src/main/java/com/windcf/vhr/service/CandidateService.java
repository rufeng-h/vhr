package com.windcf.vhr.service;

import com.windcf.vhr.model.form.EmailCodeLoginForm;
import com.windcf.vhr.model.form.EmailPwdLoginFormPwd;
import com.windcf.vhr.model.vo.LoginResultVo;
import com.windcf.vhr.security.exception.AuthenticationException;

/**
 * @author chunf
 * @time 2022-09-16 9:23
 * @package com.windcf.vhr.service
 * @description candidate service
 */
public interface CandidateService {
    /**
     * cand loginByEmail by phone
     *
     * @param form form
     * @return userinfo
     * @throws AuthenticationException authenticate fail
     */
    LoginResultVo loginByEmail(EmailPwdLoginFormPwd form) throws AuthenticationException;

    /**
     * check email
     *
     * @param email email
     * @return whether the email exists
     */
    boolean emailExists(String email);

   LoginResultVo loginByEmailCode(EmailCodeLoginForm form);
}
