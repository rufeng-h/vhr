package com.windcf.vhr.service;

import com.windcf.vhr.security.exception.AuthenticationException;

/**
 * @author chunf
 * @time 2022-09-16 10:42
 * @package com.windcf.vhr.web.controller
 * @description common service
 */
public interface VerificationCodeService {
    /**
     * send eamil verification code
     *
     * @param to email to
     */
    void sendEmailCode(String to);

    /**
     * check the email code
     *
     * @param email the email
     * @param code  the code
     * @throws AuthenticationException check error
     */
    void validateEmailCode(String email, String code) throws AuthenticationException;
}
