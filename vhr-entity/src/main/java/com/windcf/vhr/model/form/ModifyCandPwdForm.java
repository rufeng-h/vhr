package com.windcf.vhr.model.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author chunf
 * @time 2022-09-22 18:22
 * @package com.windcf.vhr.model.form
 * @description pwd modify
 */
@Data
public class ModifyCandPwdForm {
    @NotNull
    private Long candId;
    @NotBlank
    private String oldPwd;
    @NotBlank
    private String newPwd;
}
