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
 * 职位申请
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Apply {
    private Long apyId;

    /**
     * 申请人id
     */
    private Long apyCandId;

    /**
     * 职位id
     */
    private Long apyJobId;

    /**
     * 状态，'1' -> 未审核，'2' -> 通过, '3' -> 不通过
     */
    private String apyStatus;

    private LocalDateTime apyCreated;

    private LocalDateTime apyModified;

    /**
     * 操作人
     */
    private Long apyOperAdmin;
}