package com.windcf.vhr.model.form;

import com.windcf.vhr.common.enums.UserTypeEnum;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author chunf
 * @time 2022-09-16 12:20
 * @package com.windcf.vhr.model.form
 * @description email code login
 */
@Data
public class EmailCodeLoginForm {
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String code;
    @NotNull
    private UserTypeEnum userType;
}
