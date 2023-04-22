package com.anydoortrip.anydoortrip.apps.user.mapper;

import com.anydoortrip.anydoortrip.apps.user.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    // 根据userid去寻找
    @Select("SELECT * FROM user WHERE id = #{id}")
    User findById(Integer id);

    @Select("SELECT * FROM user WHERE mobile_phone = #{mobile}")
    User findByMobile(String mobile);

    @Insert("INSERT INTO user(username, mobile_phone, password, create_at, update_at, `level`,openid,profile_photo,gender,birthday,super_user) " +
            "VALUES (#{username}, #{mobilePhone}, #{password}, now(), now(), #{level},#{email},#{openid},#{profilePhoto},#{birthday},#{phoneCountryCode})")
    boolean addByMobile(User user);

//    @Select("SELECT * FROM user ")
//    User findByMobile(User user);
}