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
    * 专业
 * @author chunf
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Major {
    private String majorId;

    private String majorName;

    private String majorPid;

    private Byte majorLevel;
}