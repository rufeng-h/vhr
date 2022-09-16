package com.windcf.vhr.web.controller;

import com.windcf.vhr.common.api.ApiResponse;
import com.windcf.vhr.model.entity.Job;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author chunf
 * @time 2022-09-16 15:20
 * @package com.windcf.vhr.web.controller
 * @description job controller
 */
@RestController
@Validated
@Tag(name = "Job Api", description = "岗位接口")
@RequestMapping("/api/job")
public class JobController {
    @PostMapping
    public ApiResponse<Boolean> addJob() {
        return null;
    }

    @PutMapping
    public ApiResponse<Boolean> editJob() {
        return null;
    }

    @GetMapping("/{jobId}")
    public ApiResponse<Job> getJob(@PathVariable Long jobId) {
        return null;
    }
}
