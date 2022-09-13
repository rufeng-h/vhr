package com.windcf;

import com.windcf.common.api.ApiResponse;
import com.windcf.common.exception.VhException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author rufeng
 * @time 2022-02-28 14:48
 * @package com.rufeng.healthman.common
 * @description 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 未知异常
     */
    @ExceptionHandler(Exception.class)
    public ApiResponse<Void> unknownError(Exception e) {
        e.printStackTrace();
        return ApiResponse.unknownError();
    }

    /**
     * 项目自定义异常
     */
    @ExceptionHandler(VhException.class)
    public ApiResponse<Void> ptError(VhException e) {
        e.printStackTrace();
        return ApiResponse.clientError(e.getMessage());
    }

    /**
     * 认证异常
     *
     * @param e exp
     */
//    @ExceptionHandler(AuthenticationException.class)
//    public ApiResponse<Void> authenticationError(AuthenticationException e) {
//        return ApiResponse.authenticateFailed(e.getMessage());
//    }

    /**
     * 请求参数、请求体异常
     */
    @ExceptionHandler({BindException.class})
    public ApiResponse<Void> validateFailed() {
        return ApiResponse.validateFailed();
    }

//    @ExceptionHandler(AccessDeniedException.class)
//    public ApiResponse<Void> accessDenied() {
//        return ApiResponse.accessDenied();
//    }
}