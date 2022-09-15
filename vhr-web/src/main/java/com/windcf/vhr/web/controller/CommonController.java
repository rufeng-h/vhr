package com.windcf.vhr.web.controller;

import com.windcf.vhr.common.api.ApiResponse;
import com.windcf.vhr.model.form.AdminPhoneLoginForm;
import com.windcf.vhr.model.vo.LoginResultVo;
import com.windcf.vhr.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chunf
 * @time 2022-09-15 10:13
 * @package com.windcf.vhr.controller
 * @description common controller
 */
@RestController
@Validated
@Tag(name = "Common Api", description = "通用接口")
public class CommonController {
    private final AdminService adminService;

    public CommonController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/login")
    @Operation
    public ApiResponse<LoginResultVo> loginByPhone(@Validated @RequestBody AdminPhoneLoginForm form) {
        return ApiResponse.success(adminService.login(form));
    }
}
