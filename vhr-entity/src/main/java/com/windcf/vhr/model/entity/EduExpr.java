package com.windcf.vhr.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
    * 教育经历
 * @author chunf
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
}