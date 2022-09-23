package com.windcf.vhr.web.controller.candidate;

import com.windcf.vhr.common.api.ApiResponse;
import com.windcf.vhr.model.entity.Family;
import com.windcf.vhr.model.form.InsertOrUpdateFamilyForm;
import com.windcf.vhr.model.validation.Insert;
import com.windcf.vhr.model.validation.Update;
import com.windcf.vhr.service.FamilyService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author chunf
 * @time 2022-09-23 19:59
 * @package com.windcf.vhr.web.controller.candidate
 * @description Family Api
 */
@RestController
@Validated
@Tag(name = "Family Api", description = "家庭成员接口")
@RequestMapping("/api/fm")
public class FamilyController {
    private final FamilyService familyService;

    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    @DeleteMapping("/{fmId}")
    public ApiResponse<Boolean> delFamily(@Min(1) @PathVariable Long fmId) {
        return ApiResponse.success(familyService.delFamily(fmId));
    }

    @PostMapping
    public ApiResponse<Boolean> addFamily(@RequestBody @Validated(Insert.class) InsertOrUpdateFamilyForm form) {
        return ApiResponse.success(familyService.addFamily(form));
    }

    @PutMapping
    public ApiResponse<Boolean> updateFamily(@RequestBody @Validated(Update.class) InsertOrUpdateFamilyForm form) {
        return ApiResponse.success(familyService.updateFamily(form));
    }

    @GetMapping
    public ApiResponse<List<Family>> list(@RequestParam @NotNull @Min(1) Long fmCandId) {
        return ApiResponse.success(familyService.list(fmCandId));
    }
}
