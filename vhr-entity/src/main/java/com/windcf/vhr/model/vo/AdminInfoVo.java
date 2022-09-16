package com.windcf.vhr.model.vo;

import com.windcf.vhr.common.enums.UserTypeEnum;
import com.windcf.vhr.model.entity.Admin;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author chunf
 * @time 2022-09-16 9:25
 * @package com.windcf.vhr.model.vo
 * @description admin info vo
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AdminInfoVo extends AbstractUserInfoVo {
    public AdminInfoVo(Admin admin) {
        super(admin.getAdminId(), admin.getAdminName(), admin.getAdminAvatar(), admin.getAdminEmail(), admin.getAdminPhone(), admin.getAdminLastLogin(), UserTypeEnum.ADMIN);
    }
}
