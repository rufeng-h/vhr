package com.windcf.vhr.security.exception;

/**
 * @author chunf
 * @time 2022-09-15 9:49
 * @package com.windcf.security.exception
 * @description TODO
 */
public class AuthenticationException extends RuntimeException {
    public AuthenticationException(String message) {
        super(message);
    }
}
