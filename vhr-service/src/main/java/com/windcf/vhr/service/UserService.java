package com.windcf.vhr.service;

import com.windcf.vhr.model.entity.User;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * @author chunf
 * @time 2022-09-13 14:33
 * @package com.windcf.service
 * @description TODO
 */
public interface UserService {
    /**
     * for test
     *
     * @param id id
     * @return user
     */
    public User getUser(@NonNull Long id);

    /**
     * current cand id, if current user is amin or guest,return null
     *
     * @return id or null
     */
    @Nullable
    Long getCurrentCandId();


}
