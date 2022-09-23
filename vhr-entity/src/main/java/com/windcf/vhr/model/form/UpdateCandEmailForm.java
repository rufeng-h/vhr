package com.windcf.vhr.model.form;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author chunf
 * @time 2022-09-23 21:48
 * @package com.windcf.vhr.model.form
 * @description update email
 */
@Data
public class UpdateCandEmailForm {
    @NotBlank
    private String code;
    @Email
    @NotNull
    private String email;
}
