package com.windcf.vhr.service;

import com.windcf.vhr.model.form.*;
import com.windcf.vhr.model.vo.AbstractUserInfoVo;
import com.windcf.vhr.model.vo.CandidateInfoVo;
import com.windcf.vhr.model.vo.LoginResultVo;
import com.windcf.vhr.security.exception.AuthenticationException;
import org.springframework.lang.Nullable;

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

    /**
     * login by eamil and code
     *
     * @param form login form
     * @return login result
     */
    LoginResultVo loginByEmailCode(EmailCodeLoginForm form);

    /**
     * candidate register
     *
     * @param form reg form
     * @return candidate vo
     */
    CandidateInfoVo register(RegisterForm form);

    /**
     * check the phone
     *
     * @param phone the phone
     * @return whether phone in db
     */
    boolean phoneExists(String phone);

    /**
     * check idCard
     *
     * @param idCard the id card
     * @return whether idCard in db
     */
    boolean idCardExists(String idCard);

    /**
     * gets  candinfo
     *
     * @param candId id
     * @return info or null
     */
    AbstractUserInfoVo getCandInfo(Long candId);

    /**
     * chane pwd
     *
     * @param form formdata
     * @return success or fail
     */
    boolean modifyPwd(ModifyCandPwdForm form);

    /**
     * update candidate info
     *
     * @param form form
     * @return success or fail
     */
    boolean updateCand(UpdateCandForm form);


    boolean updateCandEmail(UpdateCandEmailForm form);
}
