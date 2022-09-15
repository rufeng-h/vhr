package com.windcf.vhr.security.handler;

import com.windcf.vhr.security.exception.AccessDeniedException;
import org.springframework.lang.NonNull;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author rufeng
 * @time 2022-04-20 0:22
 * @package com.rufeng.healthman.security.handler
 * @description TODO
 */
public interface AccessDeniedHandler {
    /**
     * @param request  req
     * @param response res
     * @param ex       ex
     * @throws IOException      ex
     * @throws ServletException ex
     */
    void onAccessDenied(@NonNull HttpServletRequest request,
                        @NonNull HttpServletResponse response,
                        @NonNull AccessDeniedException ex) throws IOException, ServletException;
}