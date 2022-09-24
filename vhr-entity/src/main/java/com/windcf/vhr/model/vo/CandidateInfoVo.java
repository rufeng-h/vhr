package com.windcf.vhr.model.vo;

import com.windcf.vhr.common.enums.GenderEnum;
import com.windcf.vhr.common.enums.UserTypeEnum;
import com.windcf.vhr.model.entity.Candidate;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collections;

/**
 * @author chunf
 * @time 2022-09-16 9:25
 * @package com.windcf.vhr.model.vo
 * @description candidate info vo
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CandidateInfoVo extends AbstractUserInfoVo {
    private String hometown;
    private String living;
    private String idCard;
    private GenderEnum gender;

    private Double visionLeft;
    private Double visionRight;
    private Integer heavy;
    private Integer height;
    private String politic;
    private String nation;


    public CandidateInfoVo(Candidate candidate) {
        super(candidate.getCandId(), candidate.getCandName(), candidate.getCandAvatar(),
                candidate.getCandEmail(), candidate.getCandPhone(), candidate.getCandLastLogin(),
                Collections.singletonList(new RoleImpl(UserTypeEnum.CANDIDATE)), candidate.getCandCreated());
        this.gender = GenderEnum.valueOf(candidate.getCandGender());
        this.hometown = candidate.getCandHometown();
        this.living = candidate.getCandLiving();
        this.idCard = candidate.getCandIdCard();

        this.visionLeft = candidate.getCandVisionLeft();
        this.visionRight = candidate.getCandVisionRight();
        this.nation = candidate.getCandNation();
        this.heavy = candidate.getCandHeavy();
        this.height = candidate.getCandHeight();
        this.politic = candidate.getCandPolitic();
    }
}
