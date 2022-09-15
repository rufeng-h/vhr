package com.windcf.vhr.web.security;

import com.windcf.vhr.security.context.SecurityContext;
import com.windcf.vhr.security.context.SecurityContextHolder;
import com.windcf.vhr.security.repositry.SecurityContextRepository;
import org.springframework.core.annotation.Order;
import org.springframework.core.log.LogMessage;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chunf
 */
@Order(1)
@Component
public class JwtTokenFilter extends OncePerRequestFilter {
    private final SecurityContextRepository contextRepository;

    public JwtTokenFilter(SecurityContextRepository contextRepository) {
        this.contextRepository = contextRepository;
    }

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain chain) throws ServletException, IOException {
        SecurityContext contextBeforeChainExecution = this.contextRepository.loadContext(request);
        try {
            SecurityContextHolder.setContext(contextBeforeChainExecution);
            if (contextBeforeChainExecution.getAuthentication() == null) {
                this.logger.debug("set empty context authentication");
            } else {
                this.logger
                        .debug(LogMessage.format("Set SecurityContextHolder to %s", contextBeforeChainExecution));
            }
            chain.doFilter(request, response);
        } finally {
            SecurityContext contextAfterChainExecution = SecurityContextHolder.getContext();
            // Crucial removal of SecurityContextHolder contents before anything else.
            SecurityContextHolder.clearContext();
            this.contextRepository.saveContext(contextAfterChainExecution, request, response);
            this.logger.debug("Cleared SecurityContextHolder to complete request");
        }
    }

}