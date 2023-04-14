package com.anydoortrip.anydoortrip.apps.user.controller;


import com.anydoortrip.anydoortrip.apps.user.pojo.User;
import com.anydoortrip.anydoortrip.apps.user.requestData.MobilePwdLoginReqData;
import com.anydoortrip.anydoortrip.apps.user.service.UserService;
import com.anydoortrip.anydoortrip.apps.utlis.BCrypt;
import com.anydoortrip.anydoortrip.apps.utlis.Jwt;
import com.anydoortrip.anydoortrip.apps.utlis.Resp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 手机号码密码登录
     *
     * @param mobilePwdLoginReqData 登录数据
     */
    @PostMapping("/mobile_pwd_login")
    public Resp mobile_pwd_login(@RequestBody @Valid MobilePwdLoginReqData mobilePwdLoginReqData) {
        Integer a = 1;
        User user = userService.getById(a);
        String token = Jwt.createToken(user);
        LinkedHashSet<Object> objects = new LinkedHashSet<>();
        objects.add(user);
        objects.add(token);
        System.out.println(token);
        BCrypt bCrypt = new BCrypt();
        System.out.println(bCrypt.get_password_hash("123456789"));
        return Resp.success(objects);
    }
}
