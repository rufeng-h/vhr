package com.windcf.vhr.security.auth;

import com.windcf.vhr.common.enums.UserTypeEnum;
import lombok.Setter;

/**
 * @author chunf
 * @time 2022-09-15 16:23
 * @package com.windcf.vhr.security.auth
 * @description authentication impl
 */
@Setter
public class AuthenticationImpl implements Authentication {
    private String username;
    private Long userId;
    private UserTypeEnum userType;

    public AuthenticationImpl(Long userId, String username, UserTypeEnum userType) {
        this.username = username;
        this.userId = userId;
        this.userType = userType;
    }

    @Override
    public Long getUserId() {
        return userId;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public UserTypeEnum getUserType() {
        return this.userType;
    }
}
