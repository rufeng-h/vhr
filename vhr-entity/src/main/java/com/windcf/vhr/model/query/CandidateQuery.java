package com.windcf.vhr.model.query;

import lombok.Data;

/**
 * @author chunf
 * @time 2022-09-15 14:46
 * @package com.windcf.vhr.model.query
 * @description Candidate mapper query
 */
@Data
public class CandidateQuery {
    private String candPhone;
    private String candEmail;
    private String candPwd;
}
