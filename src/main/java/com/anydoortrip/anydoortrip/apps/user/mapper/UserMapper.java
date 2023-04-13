package com.anydoortrip.anydoortrip.apps.user.mapper;

import com.anydoortrip.anydoortrip.apps.user.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    // 根据userid去寻找
    @Select("SELECT * FROM user WHERE id = #{id}")
    User findById(Integer id);
}