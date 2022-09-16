package com.windcf.vhr.model.vo;

import com.windcf.vhr.common.enums.UserTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author chunf
 * @time 2022-09-16 9:24
 * @package com.windcf.vhr.model.vo
 * @description userinfo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractUserInfoVo {
    private String username;
    private String avatar;
    private String email;
    private String phone;
    private LocalDateTime lastLogin;
    private UserTypeEnum userType;
}
