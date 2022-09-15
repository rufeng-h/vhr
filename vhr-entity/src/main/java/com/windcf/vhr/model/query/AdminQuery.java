package com.windcf.vhr.model.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author chunf
 * @time 2022-09-15 14:48
 * @package com.windcf.vhr.model.query
 * @description Admin mapper query
 */
@Data
@AllArgsConstructor
@Builder
public class AdminQuery {
    private String adminPhone;
    private String adminEmail;
    private String adminPwd;
}
