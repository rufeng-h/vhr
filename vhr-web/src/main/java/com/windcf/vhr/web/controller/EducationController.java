package com.windcf.vhr.web.controller;

import com.windcf.vhr.common.api.ApiResponse;
import com.windcf.vhr.model.entity.EduExpr;
import com.windcf.vhr.model.form.InsertOrUpdateEduForm;
import com.windcf.vhr.model.validation.Insert;
import com.windcf.vhr.model.validation.Update;
import com.windcf.vhr.service.EduExprService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author chunf
 * @time 2022-09-26 9:29
 * @package com.windcf.vhr.web.controller
 * @description TODO
 */
@Validated
@RestController
@RequestMapping("/api/edu")
@Tag(name = "Edu Api", description = "教育经历")
public class EducationController {
    private final EduExprService eduExprService;

    public EducationController(EduExprService eduExprService) {
        this.eduExprService = eduExprService;
    }

    @PostMapping
    public ApiResponse<EduExpr> addEdu(@RequestBody @Validated(Insert.class) InsertOrUpdateEduForm form) {
        return ApiResponse.success(eduExprService.addEdu(form));
    }

    @DeleteMapping("/{eduId}")
    public ApiResponse<Boolean> delEdu(@PathVariable Long eduId){
        return ApiResponse.success(eduExprService.delEdu(eduId));
    }

    @PutMapping
    public ApiResponse<Boolean> updateEdu(@RequestBody @Validated(Update.class) InsertOrUpdateEduForm form){
        return ApiResponse.success(eduExprService.updateEdu(form));
    }
}
