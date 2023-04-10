package com.anydoortrip.anydoortrip.apps.User.controller;

import com.anydoortrip.anydoortrip.apps.User.entity.User;
import com.anydoortrip.anydoortrip.apps.User.service.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 用户模型orm接口
     */
    private final UserRepository userRepository;

    /**
     * 构造函数
     * @param userRepository 用户模型orm接口
     */
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 获取用户信息
     * @param user_id 用户id
     * @return 用户模型
     */
    @GetMapping("/get_user")
    public Object get_user(long user_id) {
        Optional<User> user = userRepository.findById(user_id);
        return user.orElse(null);
    }
}
