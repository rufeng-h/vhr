package com.windcf.vhr.model.form;

import com.windcf.vhr.common.enums.UserTypeEnum;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author chunf
 * @time 2022-09-16 11:15
 * @package com.windcf.vhr.model.form
 * @description send email code
 */
@Data
public class SendEmailCodeForm {
    @Email
    @NotBlank
    private String email;
    @NotNull
    private UserTypeEnum userType;
}
