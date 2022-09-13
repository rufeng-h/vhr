package com.windcf.common.api;

import java.io.Serializable;

/**
 * @author rufeng
 * @time 2022-01-10 19:08
 * @package com.rufeng.healthman.common
 * @description 通用返回响应
 */
public class ApiResponse<T> implements Serializable {
    private final Long code;
    private final T data;
    private final String message;

    private ApiResponse(Long code, String message, T data) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public static <T> ApiResponse<T> serverError(String message) {
        return serverError(ApiCode.SERVER_ERROR.getCode(), message);
    }

    public static <T> ApiResponse<T> serverError() {
        return serverError(ApiCode.SERVER_ERROR.getMessage());
    }

    public static <T> ApiResponse<T> serverError(Long code, String message) {
        return new ApiResponse<>(code, message, null);
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(ApiCode.SUCCESS.getCode(), ApiCode.SUCCESS.getMessage(), data);
    }

    public static <T> ApiResponse<T> success(String message) {
        return ApiResponse.success(message, null);
    }

    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(ApiCode.SUCCESS.getCode(), message, data);
    }

    public static <T> ApiResponse<T> success() {
        return ApiResponse.success(ApiCode.SUCCESS.getMessage(), null);
    }


    public static <T> ApiResponse<T> accessDenied(String message) {
        return new ApiResponse<>(ApiCode.FORBBIDEN.getCode(), message, null);
    }

    public static <T> ApiResponse<T> accessDenied() {
        return accessDenied(ApiCode.FORBBIDEN.getMessage());
    }


    public static <T> ApiResponse<T> authenticateFailed(String message) {
        return new ApiResponse<>(ApiCode.AUTHENTICATE_FAILED.getCode(), message, null);
    }

    public static <T> ApiResponse<T> authenticateFailed() {
        return authenticateFailed(ApiCode.AUTHENTICATE_FAILED.getMessage());
    }

    public static <T> ApiResponse<T> validateFailed(String message) {
        return new ApiResponse<>(ApiCode.VALIDATE_FAILED.getCode(), message, null);
    }

    public static <T> ApiResponse<T> validateFailed() {
        return validateFailed(ApiCode.VALIDATE_FAILED.getMessage());
    }

    public static <T> ApiResponse<T> clientError(String message) {
        return new ApiResponse<>(ApiCode.CLIENT_ERROR.getCode(), message, null);
    }

    public static <T> ApiResponse<T> clientError() {
        return clientError(ApiCode.CLIENT_ERROR.getMessage());
    }

    public static <T> ApiResponse<T> unknownError() {
        return new ApiResponse<>(ApiCode.UNKNON_ERROR.getCode(), ApiCode.UNKNON_ERROR.getMessage(), null);
    }

    public String getMessage() {
        return message;
    }


    public Long getCode() {
        return code;
    }


    public T getData() {
        return data;
    }

}