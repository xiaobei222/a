package com.anydoortrip.anydoortrip.apps.user.mapper;

import com.anydoortrip.anydoortrip.apps.user.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface UserMapper {
    // 根据userid去寻找
    @Select("SELECT * FROM user WHERE id = #{id}")
    List<User> findById(Integer id);
}