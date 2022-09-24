package com.windcf.vhr.common.exception;

/**
 * @author chunf
 * @time 2022-09-24 15:44
 * @package com.windcf.vhr.common.exception
 * @description TODO
 */
public class FileException extends VhrException {
    public FileException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileException(String message) {
        super(message);
    }
}
