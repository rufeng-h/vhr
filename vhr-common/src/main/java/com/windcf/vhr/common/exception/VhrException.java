package com.windcf.vhr.common.exception;

/**
 * @author chunf
 * @time 2022-09-13 15:11
 * @package com.windcf.exception
 * @description 业务异常
 */
public class VhrException extends RuntimeException {
    public VhrException(String message) {
        super(message);
    }

    public VhrException(String message, Throwable cause) {
        super(message, cause);
    }
}
