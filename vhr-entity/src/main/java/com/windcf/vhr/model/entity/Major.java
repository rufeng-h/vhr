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
 * 专业信息
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