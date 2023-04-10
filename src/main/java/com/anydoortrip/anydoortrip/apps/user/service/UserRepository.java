package com.anydoortrip.anydoortrip.apps.user.service;

import com.anydoortrip.anydoortrip.apps.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//jpa已经为我们封装好了大量的sql语句，我们先继承一下JpaRepository<>里面的两个参数分别填写实体类和主键的类型(Long和integer都行)
public interface UserRepository extends JpaRepository<User, Long> {
    // 根据userid去寻找
    Optional<User> findById(Long userId);
}
