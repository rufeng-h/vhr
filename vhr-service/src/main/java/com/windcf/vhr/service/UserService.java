package com.windcf.vhr.service;

import com.windcf.vhr.model.entity.User;
import org.springframework.lang.NonNull;

/**
 * @author chunf
 * @time 2022-09-13 14:33
 * @package com.windcf.service
 * @description TODO
 */
public interface UserService {
    public User getUser(@NonNull Long id);
}
