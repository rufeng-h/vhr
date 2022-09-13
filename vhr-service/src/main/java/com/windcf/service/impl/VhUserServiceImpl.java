package com.windcf.service.impl;

import com.windcf.entity.User;
import com.windcf.mapper.UserMapper;
import com.windcf.service.VhUserService;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

/**
 * @author chunf
 * @time 2022-09-13 14:34
 * @package com.windcf.service.impl
 * @description TODO
 */
@Service
public class VhUserServiceImpl implements VhUserService {
    private final UserMapper userMapper;

    public VhUserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User getUser(@NonNull Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
