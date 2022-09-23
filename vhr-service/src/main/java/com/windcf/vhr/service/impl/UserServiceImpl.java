package com.windcf.vhr.service.impl;

import com.windcf.vhr.common.enums.UserTypeEnum;
import com.windcf.vhr.model.entity.User;
import com.windcf.vhr.mapper.UserMapper;
import com.windcf.vhr.security.auth.Authentication;
import com.windcf.vhr.security.context.SecurityContextHolder;
import com.windcf.vhr.service.UserService;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

/**
 * @author chunf
 * @time 2022-09-13 14:34
 * @package com.windcf.service.impl
 * @description common user service
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

    @Override
    public Long getCurrentCandId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getUserType() != UserTypeEnum.CANDIDATE) {
            return null;
        }
        return authentication.getUserId();
    }

}
