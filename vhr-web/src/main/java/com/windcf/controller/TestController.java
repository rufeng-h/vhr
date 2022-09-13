package com.windcf.controller;

import com.windcf.ApiResponse;
import com.windcf.entity.User;
import com.windcf.service.VhUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chunf
 * @time 2022-09-13 12:41
 * @package com.windcf.controller
 * @description TODO
 */
@RestController
public class TestController {
    private final VhUserService vhUserService;

    public TestController(VhUserService vhUserService) {
        this.vhUserService = vhUserService;
    }

    @GetMapping("/{id}")
    public ApiResponse<User> test(@PathVariable Long id) {
        return ApiResponse.success(vhUserService.getUser(id));
    }
}
