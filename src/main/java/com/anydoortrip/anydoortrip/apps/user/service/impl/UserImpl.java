package com.anydoortrip.anydoortrip.apps.user.service.impl;

import com.anydoortrip.anydoortrip.apps.user.mapper.UserMapper;
import com.anydoortrip.anydoortrip.apps.user.pojo.User;
import com.anydoortrip.anydoortrip.apps.user.service.UserService;
import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
@DS("db2")
public class UserImpl implements UserService {

    @Autowired

    private UserMapper userMapper;
    @Override
    public List<User> getById(Integer id) {
        return userMapper.findById(id);
    }
}
