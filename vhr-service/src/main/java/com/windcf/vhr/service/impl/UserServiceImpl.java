package com.windcf.vhr.service.impl;

import com.windcf.vhr.model.entity.User;
import com.windcf.vhr.mapper.UserMapper;
import com.windcf.vhr.service.UserService;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

/**
 * @author chunf
 * @time 2022-09-13 14:34
 * @package com.windcf.service.impl
 * @description TODO
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User getUser(@NonNull Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
