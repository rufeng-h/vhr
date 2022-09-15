package com.windcf.vhr.security.context;

import com.windcf.vhr.security.auth.Authentication;
import org.springframework.lang.Nullable;

/**
 * @author chunf
 * @time 2022-09-15 9:46
 * @package com.windcf.security.context
 * @description TODO
 */
public interface SecurityContext {
    /**
     * Gets the current authentication
     *
     * @return authentication
     */
    @Nullable
    Authentication getAuthentication();

    /**
     * Sets the authentication
     *
     * @param authentication the authentication
     */
    void setAuthentication(@Nullable Authentication authentication);

    /**
     * Check if the current context has authenticated or not.
     *
     * @return true if authenticate; false otherwise
     */
    default boolean isAuthenticated() {
        return getAuthentication() != null;
    }
}
