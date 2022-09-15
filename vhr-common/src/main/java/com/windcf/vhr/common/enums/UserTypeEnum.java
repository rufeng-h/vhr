package com.windcf.vhr.common.enums;

import lombok.Getter;

/**
 * @author chunf
 * @time 2022-09-15 16:00
 * @package com.windcf.vhr.common.enums
 * @description user type enum
 */
@Getter
public enum UserTypeEnum {
    /**
     * user type enum
     */
    CANDIDATE("求职者"),
    ADMIN("管理员");

    private final String type;

    UserTypeEnum(String type) {
        this.type = type;
    }
}
