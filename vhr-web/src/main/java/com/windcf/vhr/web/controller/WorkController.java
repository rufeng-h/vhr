package com.windcf.vhr.web.controller;

import com.windcf.vhr.common.api.ApiResponse;
import com.windcf.vhr.model.entity.WorkExpr;
import com.windcf.vhr.model.form.InsertOrUpdateWorkForm;
import com.windcf.vhr.model.validation.Insert;
import com.windcf.vhr.model.validation.Update;
import com.windcf.vhr.service.WorkExprService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author chunf
 * @time 2022-09-26 15:23
 * @package com.windcf.vhr.web.controller
 * @description TODO
 */
@RestController
@Validated
@RequestMapping("/api/work")
@Tag(name = "Work Api", description = "工作经历接口")
public class WorkController {
    private final WorkExprService workExprService;

    public WorkController(WorkExprService workExprService) {
        this.workExprService = workExprService;
    }

    @PostMapping
    public ApiResponse<WorkExpr> addWork(@RequestBody @Validated(Insert.class) InsertOrUpdateWorkForm form) {
        return ApiResponse.success(workExprService.addWork(form));
    }

    @PutMapping
    public ApiResponse<Boolean> updateWork(@RequestBody @Validated(Update.class) InsertOrUpdateWorkForm form) {
        return ApiResponse.success(workExprService.updateWork(form));
    }

    @DeleteMapping("/{workId}")
    public ApiResponse<Boolean> delWork(@PathVariable Long workId) {
        return ApiResponse.success(workExprService.delWork(workId));
    }
}
