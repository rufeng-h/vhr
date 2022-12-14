package com.windcf.vhr.model.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author chunf
 * @time 2022-09-15 14:28
 * @package com.windcf.vhr.model
 * @description TODO
 */

/**
    * 用户表
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Candidate {
    private Long candId;

    /**
    * 真实姓名
    */
    private String candName;

    /**
    * 籍贯，外键，程序保证
    */
    private Long candHometown;

    /**
    * 邮箱，程序保证唯一性
    */
    private String candEmail;

    /**
    * 手机号，程序保证唯一性
    */
    private String candPhone;

    /**
    * 性别，MF
    */
    private String candGender;

    /**
    * 密码
    */
    private String candPwd;

    /**
    * 创建时间
    */
    private LocalDateTime candCreated;

    /**
    * 上次登录
    */
    private LocalDateTime candLastLogin;

    /**
    * 账号状态，'1' -> 正常，'2 '-> 禁用，'3'-> 删除
    */
    private String candStatus;

    /**
    * 头像
    */
    private String candAvatar;

    /**
    * 身份证号，程序保证唯一性
    */
    private String candIdCard;

    /**
    * 现居住地，同籍贯
    */
    private Long candLiving;
}