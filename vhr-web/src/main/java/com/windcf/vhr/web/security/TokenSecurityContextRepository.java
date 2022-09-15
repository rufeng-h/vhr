package com.windcf.vhr.web.security;

import com.windcf.vhr.common.enums.UserTypeEnum;
import com.windcf.vhr.common.util.JwtTokenUtil;
import com.windcf.vhr.security.auth.Authentication;
import com.windcf.vhr.security.auth.AuthenticationImpl;
import com.windcf.vhr.security.context.SecurityContext;
import com.windcf.vhr.security.context.SecurityContextHolder;
import com.windcf.vhr.security.repositry.SecurityContextRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.windcf.vhr.common.config.OpenApiConfig.JWT_HEADER_NAME;

/**
 * @author chunf
 */
@Component
@Slf4j
public class TokenSecurityContextRepository implements SecurityContextRepository {
    @Override
    @NonNull
    public SecurityContext loadContext(HttpServletRequest request) {
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        String token = request.getHeader(JWT_HEADER_NAME);
        if (token == null) {
            log.debug("未认证用户！");
            return context;
        }
        Claims claims;
        try {
            claims = JwtTokenUtil.getClaimsBody(token);
        } catch (JwtException ex) {
            log.warn("不合法的JWT信息！");
            return context;
        }
        Long userId = Long.parseLong(claims.getId());
        UserTypeEnum userType = UserTypeEnum.valueOf(claims.getSubject());
        String username = claims.getAudience();

        Authentication authentication = new AuthenticationImpl(userId, username, userType);

        log.debug(authentication.getUserType() + ": " + authentication.getUsername());
        context.setAuthentication(authentication);
        return context;
    }

    /**
     * 完全存储在客户端，服务端空实现
     */
    @Override
    public void saveContext(SecurityContext context, HttpServletRequest request, HttpServletResponse response) {

    }
}