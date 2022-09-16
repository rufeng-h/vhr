package com.windcf.vhr.model.vo;

import com.windcf.vhr.common.enums.UserTypeEnum;
import com.windcf.vhr.model.entity.Candidate;
import com.windcf.vhr.model.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author chunf
 * @time 2022-09-16 9:25
 * @package com.windcf.vhr.model.vo
 * @description candidate info vo
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CandidateInfoVo extends AbstractUserInfoVo {

    public CandidateInfoVo(Candidate candidate) {
        super(candidate.getCandName(), candidate.getCandAvatar(), candidate.getCandEmail(), candidate.getCandPhone(), candidate.getCandLastLogin(), UserTypeEnum.CANDIDATE);
    }
}
