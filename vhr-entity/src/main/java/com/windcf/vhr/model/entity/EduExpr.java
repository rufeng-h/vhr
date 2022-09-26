package com.windcf.vhr.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author chunf
 * @time 2022-09-26 9:30
 * @package com.windcf.vhr.model.entity
 * @description TODO
 */

/**
 * 教育经历
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EduExpr {
    private Long eduId;

    /**
     * 学历，0 -> 初中及以下，1 -> 高中，2 -> 本科，
     */
    private String eduEducation;

    /**
     * 学校
     */
    private String eduSchool;

    /**
     * 专业，本科以下选填
     */
    private String eduMajor;

    /**
     * 专业描述
     */
    private String eduMajorDesc;

    private LocalDate eduStartDate;

    private LocalDate eduEndDate;

    private LocalDateTime eduCreated;

    private LocalDateTime eduModified;

    /**
     * 外键
     */
    private Long eduCandId;

    /**
     * 所属简历
     */
    private Long eduRsId;
}