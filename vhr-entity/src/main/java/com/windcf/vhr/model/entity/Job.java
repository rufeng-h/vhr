package com.windcf.vhr.model.entity;

import java.time.LocalDateTime;
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
 * 工作岗位
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    private Long jobId;

    /**
     * 工作地点
     */
    private Long jobArea;

    private String jobName;

    /**
     * 工作年限
     */
    private Byte jobYear;

    /**
     * 学历要求
     */
    private String jobEdu;

    /**
     * 月薪，d+-d+k
     */
    private String jobSalary;

    /**
     * 岗位职责
     */
    private String jobDuty;

    /**
     * 任职要求
     */
    private String jobReq;

    /**
     * 所属行业
     */
    private String jobInd;

    /**
     * 福利待遇，逗号分隔
     */
    private String jobWeal;

    private LocalDateTime jobCreated;

    private LocalDateTime jobModified;

    /**
     * 过期时间，null长期有效
     */
    private LocalDateTime jobExpired;
}