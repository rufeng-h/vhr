package com.windcf.vhr.controller;

import com.windcf.vhr.common.api.ApiResponse;
import com.windcf.vhr.model.entity.User;
import com.windcf.vhr.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Common Api", description = "通用接口")
public class TestController {
    private final UserService userService;

    public TestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ApiResponse<User> test(@PathVariable @Min(1) Long id) {
        return ApiResponse.success(userService.getUser(id));
    }
}
