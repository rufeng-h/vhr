package com.windcf.service;

import com.windcf.entity.User;
import org.springframework.lang.NonNull;

/**
 * @author chunf
 * @time 2022-09-13 14:33
 * @package com.windcf.service
 * @description TODO
 */
public interface VhUserService {
    public User getUser(@NonNull Long id);
}
