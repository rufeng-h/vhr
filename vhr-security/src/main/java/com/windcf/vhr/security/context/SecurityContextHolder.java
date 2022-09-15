package com.windcf.vhr.security.context;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;


/**
 * @author rufeng
 */
final public class SecurityContextHolder {

    private static final ThreadLocal<SecurityContext> CONTEXT_HOLDER = new ThreadLocal<>();

    private SecurityContextHolder() {
    }

    /**
     * Gets context.
     *
     * @return security context
     */
    @NonNull
    public static SecurityContext getContext() {
        // Get from thread local
        SecurityContext context = CONTEXT_HOLDER.get();
        if (context == null) {
            // If no context is available now then create an empty context
            context = createEmptyContext();
            // Set to thread local
            CONTEXT_HOLDER.set(context);
        }
        return context;
    }

    /**
     * Sets security context.
     *
     * @param context security context
     */
    public static void setContext(@Nullable SecurityContext context) {
        CONTEXT_HOLDER.set(context);
    }

    /**
     * Clears context.
     */
    public static void clearContext() {
        CONTEXT_HOLDER.remove();
    }

    /**
     * Creates an empty security context.
     *
     * @return an empty security context
     */
    @NonNull
    public static SecurityContext createEmptyContext() {
        return new SecurityContextImpl(null);
    }
}