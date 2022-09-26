package com.windcf.vhr.web.controller;

import com.windcf.vhr.common.api.ApiResponse;
import com.windcf.vhr.model.entity.Advantage;
import com.windcf.vhr.model.form.InsertOrUpdateAdvForm;
import com.windcf.vhr.model.validation.Insert;
import com.windcf.vhr.model.validation.Update;
import com.windcf.vhr.service.AdvantageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author chunf
 * @time 2022-09-25 22:25
 * @package com.windcf.vhr.web.controller
 * @description TODO
 */
@Validated
@RestController
@RequestMapping("/api/adv")
@Tag(name = "Adv api", description = "个人优势")
public class AdvantageController {
    private final AdvantageService advantageService;

    public AdvantageController(AdvantageService advantageService) {
        this.advantageService = advantageService;
    }

    @PostMapping
    public ApiResponse<Advantage> addAdv(@RequestBody @Validated(Insert.class) InsertOrUpdateAdvForm form) {
        return ApiResponse.success(advantageService.addAdv(form));
    }

    @PutMapping
    public ApiResponse<Boolean> updateAdv(@RequestBody @Validated(Update.class) InsertOrUpdateAdvForm form) {
        return ApiResponse.success(advantageService.updateAdv(form));
    }
}
