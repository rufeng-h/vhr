package com.windcf.vhr.web.controller;

import com.windcf.vhr.common.api.ApiResponse;
import com.windcf.vhr.model.entity.Resume;
import com.windcf.vhr.model.vo.ResumeInfo;
import com.windcf.vhr.service.ResumeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author chunf
 * @time 2022-09-24 18:58
 * @package com.windcf.vhr.web.controller
 * @description TODO
 */
@Validated
@RestController
@RequestMapping("/api/resume")
@Tag(name = "Resume Api", description = "简历")
public class ResumeController {
    private final ResumeService resumeService;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @GetMapping
    public ApiResponse<List<Resume>> listResume(@RequestParam Long candId) {
        return ApiResponse.success(resumeService.listResume(candId));
    }

    @PostMapping
    public ApiResponse<Boolean> addResume() {
        return ApiResponse.success(resumeService.addResume());
    }


    @GetMapping("/{rsId}")
    public ApiResponse<ResumeInfo> getResume(@PathVariable Long rsId) {
        return ApiResponse.success(resumeService.getResume(rsId));
    }
}
