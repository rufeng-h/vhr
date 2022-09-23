package com.windcf.vhr.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

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
    private Long userId;
    private String username;
    private String avatar;
    private String email;
    private String phone;
    private LocalDateTime lastLogin;
    private List<Role> roles;
    private LocalDateTime created;
}
