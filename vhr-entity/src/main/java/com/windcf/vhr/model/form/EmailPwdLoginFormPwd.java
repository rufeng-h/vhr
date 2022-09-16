package com.windcf.vhr.model.form;

import com.windcf.vhr.common.enums.UserTypeEnum;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author chunf
 * @time 2022-09-15 14:41
 * @package com.windcf.vhr.model.form
 * @description email password login
 */
@Data
public class EmailPwdLoginFormPwd {
    @NotNull
    @Email
    private String email;
    @NotBlank
    private String password;
    @NotNull
    private UserTypeEnum userType;
}
