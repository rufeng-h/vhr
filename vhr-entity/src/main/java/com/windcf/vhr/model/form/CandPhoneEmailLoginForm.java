package com.windcf.vhr.model.form;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author chunf
 * @time 2022-09-15 14:37
 * @package com.windcf.vhr.model.form
 * @description 求职者邮箱登录
 */
@Data
public class CandPhoneEmailLoginForm {
    @Email
    private String email;
    @NotBlank
    private String password;
}
