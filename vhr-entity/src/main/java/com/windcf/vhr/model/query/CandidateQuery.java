package com.windcf.vhr.model.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author chunf
 * @time 2022-09-15 14:46
 * @package com.windcf.vhr.model.query
 * @description Candidate mapper query
 */
@Data
@AllArgsConstructor
@Builder
public class CandidateQuery {
    private String candPhone;
    private String candEmail;
    private String candPwd;
    private String candIdCard;
}
