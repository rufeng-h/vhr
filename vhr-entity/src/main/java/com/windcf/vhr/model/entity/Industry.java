package com.windcf.vhr.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author chunf
 * @time 2022-09-22 17:15
 * @package com.windcf.vhr.model.entity
 * @description TODO
 */

/**
 * 行业信息
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Industry {
    private String indId;

    private String indName;

    private String indPid;

    private Byte indLevel;
}