package com.windcf.vhr.model.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author chunf
 * @time 2022-09-15 10:22
 * @package com.windcf.vhr.form
 * @description 求职者手机登录
 */
@Data
public class CandPhoneLoginForm {
    @Pattern(regexp = "^1(3\\d|4[5-9]|5[0-35-9]|6[2567]|7[0-8]|8\\d|9[0-35-9])\\d{8}$")
    private String phone;
    @NotBlank
    private String password;
}
