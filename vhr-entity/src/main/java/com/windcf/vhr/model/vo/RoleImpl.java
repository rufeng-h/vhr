package com.windcf.vhr.model.vo;

import com.windcf.vhr.common.enums.UserTypeEnum;

/**
 * @author chunf
 * @time 2022-09-20 10:59
 * @package com.windcf.vhr.model.vo
 * @description simple roleimpl
 */
public class RoleImpl implements Role {
    private UserTypeEnum userType;

    public RoleImpl(UserTypeEnum userType) {
        this.userType = userType;
    }

    @Override
    public String getRoleName() {
        return this.userType.getType();
    }

    @Override
    public String getValue() {
        return this.userType.name();
    }
}
