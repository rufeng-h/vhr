package com.windcf.vhr.common.enums;

import lombok.Getter;

/**
 * @author chunf
 * @time 2022-09-16 15:00
 * @package com.windcf.vhr.common.enums
 * @description gender enum
 */
@Getter
public enum GenderEnum {
    /**
     * gender
     */
    M("男"), F("女");
    private final String gender;

    GenderEnum(String gender) {
        this.gender = gender;
    }
}
