package com.windcf.vhr.model.form;

import com.windcf.vhr.common.enums.UserTypeEnum;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author chunf
 * @time 2022-09-16 9:10
 * @package com.windcf.vhr.model.form
 * @description phone login
 */
@Data
public class PhoneLoginForm {
    @Email
    @NotBlank
//    @Pattern(regexp = "^1(3\\d|4[5-9]|5[0-35-9]|6[2567]|7[0-8]|8\\d|9[0-35-9])\\d{8}$")
    private String phone;
    @NotBlank
    private String smsCode;
    @NotNull
    private UserTypeEnum userType;
}
