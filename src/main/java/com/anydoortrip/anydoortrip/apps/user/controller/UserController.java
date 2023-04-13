package com.anydoortrip.anydoortrip.apps.user.controller;


import com.anydoortrip.anydoortrip.apps.user.pojo.User;
import com.anydoortrip.anydoortrip.apps.user.requestData.MobilePwdLoginReqData;
import com.anydoortrip.anydoortrip.apps.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 手机号码密码登录
     * @param mobilePwdLoginReqData 登录数据
     */
    @PostMapping("/mobile_pwd_login")
    public void  mobile_pwd_login(@RequestBody @Valid MobilePwdLoginReqData mobilePwdLoginReqData){
        Integer a = 7;
        List<User> byId = userService.getById(a);


        System.out.println(byId);
    }
}
