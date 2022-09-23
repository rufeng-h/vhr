package com.windcf.vhr.web.controller.candidate;

import com.windcf.vhr.common.api.ApiResponse;
import com.windcf.vhr.model.form.ModifyCandPwdForm;
import com.windcf.vhr.model.form.UpdateCandEmailForm;
import com.windcf.vhr.model.form.UpdateCandForm;
import com.windcf.vhr.service.CandidateService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chunf
 * @time 2022-09-22 18:21
 * @package com.windcf.vhr.web.controller.candidate
 * @description TODO
 */
@RestController
@Validated
@RequestMapping("/api/cand")
public class CandidateController {
    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PutMapping("/pwd")
    public ApiResponse<Boolean> modifyPwd(@Validated @RequestBody ModifyCandPwdForm form) {
        return ApiResponse.success(candidateService.modifyPwd(form));
    }

    @PutMapping
    public ApiResponse<Boolean> updateCand(@Validated @RequestBody UpdateCandForm form) {
        return ApiResponse.success(candidateService.updateCand(form));
    }


    @PutMapping("/email")
    public ApiResponse<Boolean> updateCandEmail(@Validated @RequestBody UpdateCandEmailForm form) {
        return ApiResponse.success(candidateService.updateCandEmail(form));
    }
}
