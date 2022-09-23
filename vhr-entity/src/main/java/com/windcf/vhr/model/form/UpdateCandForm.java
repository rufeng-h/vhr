package com.windcf.vhr.model.form;

import com.windcf.vhr.common.enums.GenderEnum;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author chunf
 * @time 2022-09-22 18:34
 * @package com.windcf.vhr.model.form
 * @description update cand info
 */
@Data
public class UpdateCandForm {
    @NotNull
    private Long candId;

    @Length(min = 1)
    private String candName;
    @Length(min = 1)
    private String candPhone;
    @Length(min = 1)
    private String candEmail;
    @Length(min = 1)
    private String candHometown;
    @Length(min = 1)
    private String candLiving;
}
