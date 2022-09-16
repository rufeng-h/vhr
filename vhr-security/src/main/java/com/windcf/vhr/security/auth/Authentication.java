package com.windcf.vhr.security.auth;

import com.windcf.vhr.common.enums.UserTypeEnum;

import java.io.Serializable;

/**
 * @author chunf
 * @time 2022-09-15 9:12
 * @package com.windcf.security.auth
 * @description TODO
 */
public interface Authentication extends Serializable {
    /**
     * get the user id
     *
     * @return user id
     */
    Long getUserId();

    /**
     * get username
     *
     * @return username
     */
    String getUsername();

    /**
     * get the use type
     *
     * @return usertype
     */
    UserTypeEnum getUserType();
}
