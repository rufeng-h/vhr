package com.windcf.vhr.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author chunf
 * @time 2022-09-15 14:28
 * @package com.windcf.vhr.model
 * @description TODO
 */

/**
    * 行业
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