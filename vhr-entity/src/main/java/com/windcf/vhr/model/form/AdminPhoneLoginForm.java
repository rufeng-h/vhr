package com.windcf.vhr.model.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author chunf
 * @time 2022-09-15 14:41
 * @package com.windcf.vhr.model.form
 * @description admin phone login
 */
@Data
public class AdminPhoneLoginForm {
    @Pattern(regexp = "^1(3\\d|4[5-9]|5[0-35-9]|6[2567]|7[0-8]|8\\d|9[0-35-9])\\d{8}$")
    private String adminPhone;
    @NotBlank
    private String adminPwd;
}
