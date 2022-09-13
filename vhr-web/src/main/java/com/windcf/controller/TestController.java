package com.windcf.controller;

import com.windcf.common.api.ApiResponse;
import com.windcf.entity.User;
import com.windcf.service.VhUserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;

/**
 * @author chunf
 * @time 2022-09-13 12:41
 * @package com.windcf.controller
 * @description TODO
 */
@RestController
@Validated
public class TestController {
    private final VhUserService vhUserService;

    public TestController(VhUserService vhUserService) {
        this.vhUserService = vhUserService;
    }

    @GetMapping("/{id}")
    public ApiResponse<User> test(@PathVariable @Min(1) Long id) {
        return ApiResponse.success(vhUserService.getUser(id));
    }
}
