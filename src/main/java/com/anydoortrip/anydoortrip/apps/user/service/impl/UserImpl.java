package com.anydoortrip.anydoortrip.apps.user.service.impl;

import com.anydoortrip.anydoortrip.apps.user.mapper.UserMapper;
import com.anydoortrip.anydoortrip.apps.user.pojo.User;
import com.anydoortrip.anydoortrip.apps.user.service.UserService;
import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImpl implements UserService {

    @Autowired
    private final UserMapper userMapper;

    public UserImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    @DS("user")
    public User getById(Integer id) {
        return userMapper.findById(id);
    }
}
