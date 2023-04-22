package com.anydoortrip.anydoortrip.apps.user.service.impl;

import com.anydoortrip.anydoortrip.apps.user.mapper.UserMapper;
import com.anydoortrip.anydoortrip.apps.user.pojo.MobilePwdLoginReqData;
import com.anydoortrip.anydoortrip.apps.user.pojo.User;
import com.anydoortrip.anydoortrip.apps.user.service.UserService;
import com.anydoortrip.anydoortrip.apps.utlis.AppExceptionCodeMsg;
import com.anydoortrip.anydoortrip.apps.utlis.BCrypt;
import com.anydoortrip.anydoortrip.apps.utlis.Jwt;
import com.anydoortrip.anydoortrip.apps.utlis.Resp;
import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
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

    @Override
    @DS("user")
    public User getByMobile(String mobile) {
        return userMapper.findByMobile(mobile);
    }

    @Override
    @DS("user")
    public boolean addByMobile(User user) {
        User byMobile = userMapper.findByMobile(user.getMobilePhone());
        System.out.println(byMobile);
        if (byMobile != null) {
            return false;
        } else {
            boolean byMobiles = userMapper.addByMobile(user);

            return byMobiles;


        }
    }


}
