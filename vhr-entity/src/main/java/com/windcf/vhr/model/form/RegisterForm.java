package com.windcf.vhr.model.form;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author chunf
 * @time 2022-09-16 14:09
 * @package com.windcf.vhr.model.form
 * @description candidate register form
 */
@Data
public class RegisterForm {
    @NotBlank
    private String username;
    @Pattern(regexp = "^1(3\\d|4[5-9]|5[0-35-9]|6[2567]|7[0-8]|8\\d|9[0-35-9])\\d{8}$")
    @NotNull
    private String phone;
    @NotNull
    @Email
    private String email;
    @NotBlank
    private String password;
    @NotNull
    @Pattern(regexp = "^([1-6][1-9]|50)\\d{4}(18|19|20)\\d{2}((0[1-9])|10|11|12)(([0-2][1-9])|10|20|30|31)\\d{3}[\\dXx]$")
    private String idCard;
    @NotBlank
    private String emailCode;
}
