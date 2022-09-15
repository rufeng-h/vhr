package com.windcf.vhr.common.enums;

import lombok.Getter;

/**
 * @author chunf
 * @time 2022-09-15 15:51
 * @package com.windcf.vhr.common.enums
 * @description job apply status enum
 */
@Getter
public enum ApplyStatusEnum {
    /**
     * job apply status enum
     */
    WAIT_FOR_CHECK('1', "等待审核"),
    PASSED('2', "已通过"),
    NOT_PASSED('3', "未通过");
    private final Character value;
    private final String status;

    ApplyStatusEnum(Character value, String status) {
        this.value = value;
        this.status = status;
    }
}
