package com.windcf.vhr.model.form;

import com.windcf.vhr.model.validation.Insert;
import com.windcf.vhr.model.validation.Update;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * @author chunf
 * @time 2022-09-23 20:18
 * @package com.windcf.vhr.model.form
 * @description form for insert family
 */
@Data
public class InsertOrUpdateFamilyForm {
    @NotNull(groups = Update.class)
    @Null(groups = Insert.class)
    private Long fmId;
    @NotNull
    private Long fmCandId;
    @NotBlank
    private String fmName;
    @NotBlank
    private String fmRelation;
    @NotBlank
    private String fmCompany;
    @NotBlank
    private String fmPosition;
}
