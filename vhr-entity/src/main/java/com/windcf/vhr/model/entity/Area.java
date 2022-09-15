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
    * 全国行政区划
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Area {
    private Long areaId;

    private String areaName;

    private Long areaPid;

    private Short areaLevel;
}