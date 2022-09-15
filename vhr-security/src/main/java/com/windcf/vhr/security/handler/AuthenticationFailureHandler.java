package com.windcf.vhr.security.handler;

import com.windcf.vhr.security.exception.AuthenticationException;
import org.springframework.lang.NonNull;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author rufeng
 * @time 2022-04-20 0:14
 * @package com.rufeng.healthman.security.handler
 * @description TODO
 */
public interface AuthenticationFailureHandler {
    /**
     * 认证失败
     *
     * @param request  req
     * @param response res
     * @param ex       ex
     * @throws ServletException ex
     * @throws IOException      ex
     */
    void onAuthenticateFail(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull AuthenticationException ex) throws IOException, ServletException;
}