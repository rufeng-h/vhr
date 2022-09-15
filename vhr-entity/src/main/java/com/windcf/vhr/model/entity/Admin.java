package com.windcf.vhr.model.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author chunf
 * @time 2022-09-15 16:11
 * @package com.windcf.vhr.model.entity
 * @description TODO
 */

/**
 * 管理员
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private Long adminId;

    private String adminName;

    private String adminPhone;

    private String adminEmail;

    private String adminAvatar;

    private LocalDateTime adminCreated;

    private LocalDateTime adminModified;

    private String adminStatus;

    private String adminPwd;

    private LocalDateTime adminLastLogin;
}