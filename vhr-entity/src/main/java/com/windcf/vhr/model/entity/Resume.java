package com.windcf.vhr.model.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author chunf
 * @time 2022-09-25 16:04
 * @package com.windcf.vhr.model.entity
 * @description TODO
 */

/**
 * 简历
 *
 * @author chunf
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Resume {
    private Long rsId;

    private String rsName;

    private String rsDesc;

    private LocalDateTime rsCreated;

    private LocalDateTime rsModified;

    private Long rsCandId;

    private Boolean rsPublic;

    private Boolean rsDefault;
}