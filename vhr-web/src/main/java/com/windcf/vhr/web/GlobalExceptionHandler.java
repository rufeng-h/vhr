package com.windcf.vhr.web;

import com.windcf.vhr.common.api.ApiResponse;
import com.windcf.vhr.common.exception.VhrException;
import com.windcf.vhr.security.exception.AccessDeniedException;
import com.windcf.vhr.security.exception.AuthenticationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.mail.MailException;
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
    @ExceptionHandler(VhrException.class)
    public ApiResponse<Void> ptError(VhrException e) {
        e.printStackTrace();
        return ApiResponse.clientError(e.getMessage());
    }

    /**
     * 认证异常
     *
     * @param e exp
     */
    @ExceptionHandler(AuthenticationException.class)
    public ApiResponse<Void> authenticationError(AuthenticationException e) {
        return ApiResponse.authenticateFailed(e.getMessage());
    }

    /**
     * 请求参数、请求体异常
     */
    @ExceptionHandler({BindException.class, HttpMessageNotReadableException.class})
    public ApiResponse<Void> validateFailed() {
        return ApiResponse.validateFailed();
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ApiResponse<Void> accessDenied() {
        return ApiResponse.accessDenied();
    }


    @ExceptionHandler(MailException.class)
    public ApiResponse<Void> mailExp(MailException e) {
        e.printStackTrace();
        return ApiResponse.serverError("发送邮件失败");
    }
}