package com.windcf.vhr.web.controller;

import com.windcf.vhr.common.api.ApiResponse;
import com.windcf.vhr.common.enums.UserTypeEnum;
import com.windcf.vhr.model.form.EmailCodeLoginForm;
import com.windcf.vhr.model.form.EmailPwdLoginFormPwd;
import com.windcf.vhr.model.form.RegisterForm;
import com.windcf.vhr.model.form.SendEmailCodeForm;
import com.windcf.vhr.model.vo.CandidateInfoVo;
import com.windcf.vhr.model.vo.LoginResultVo;
import com.windcf.vhr.service.AdminService;
import com.windcf.vhr.service.CandidateService;
import com.windcf.vhr.service.VerificationCodeService;
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
    private final CandidateService candidateService;

    private final VerificationCodeService verificationCodeService;


    public CommonController(AdminService adminService, CandidateService candidateService, VerificationCodeService verificationCodeService) {
        this.adminService = adminService;
        this.candidateService = candidateService;
        this.verificationCodeService = verificationCodeService;
    }

    @PostMapping("/login/email")
    public ApiResponse<LoginResultVo> loginByPhone(@Validated @RequestBody EmailPwdLoginFormPwd form) {
        return form.getUserType() == UserTypeEnum.ADMIN ? ApiResponse.success(adminService.loginByEmail(form)) :
                ApiResponse.success(candidateService.loginByEmail(form));
    }

    @PostMapping("/login/EmailCode")
    public ApiResponse<LoginResultVo> loginByCode(@Validated @RequestBody EmailCodeLoginForm form) {
        LoginResultVo resultVo = form.getUserType() == UserTypeEnum.ADMIN ? adminService.loginByEmailCode(form) :
                candidateService.loginByEmailCode(form);
        return ApiResponse.success(resultVo);
    }

    @PostMapping("/emailCode")
    public ApiResponse<Void> sendEmailCode(@Validated @RequestBody SendEmailCodeForm form) {
        String email = form.getEmail();
        boolean b = form.getUserType() == UserTypeEnum.ADMIN ? adminService.emailExists(email) :
                candidateService.emailExists(email);
        if (b) {
            verificationCodeService.sendEmailCode(email);
            return ApiResponse.success();
        }
        return ApiResponse.authenticateFailed("邮箱不存在");
    }

    @PostMapping("/register")
    public ApiResponse<CandidateInfoVo> candRegister(@Validated @RequestBody RegisterForm form) {
        return ApiResponse.success(candidateService.register(form));
    }
}
