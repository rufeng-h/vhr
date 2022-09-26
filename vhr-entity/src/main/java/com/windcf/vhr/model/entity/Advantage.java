package com.windcf.vhr.model.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author chunf
 * @time 2022-09-25 22:37
 * @package com.windcf.vhr.model.entity
 * @description TODO
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Advantage {
    private Long advId;

    private String advContent;

    private LocalDateTime advCreated;

    private LocalDateTime advModified;

    private Long advCandId;

    private Long advRsId;
}