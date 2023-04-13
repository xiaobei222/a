package com.anydoortrip.anydoortrip.apps.user.mapper;

import com.anydoortrip.anydoortrip.apps.user.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Mapper

public interface UserMapper {
    // 根据userid去寻找
    List<User> findById(Integer id);
}
