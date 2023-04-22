package com.anydoortrip.anydoortrip.apps.user.controller;


import com.anydoortrip.anydoortrip.apps.user.pojo.User;
import com.anydoortrip.anydoortrip.apps.user.pojo.MobilePwdLoginReqData;
import com.anydoortrip.anydoortrip.apps.user.service.UserService;
import com.anydoortrip.anydoortrip.apps.utlis.AppExceptionCodeMsg;
import com.anydoortrip.anydoortrip.apps.utlis.BCrypt;
import com.anydoortrip.anydoortrip.apps.utlis.Jwt;
import com.anydoortrip.anydoortrip.apps.utlis.Resp;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.el.parser.Token;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

import static com.mysql.cj.conf.PropertyKey.logger;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private  UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 手机号码密码登录
     *
     * @param mobilePwdLoginReqData 登录数据
     */
    @PostMapping("/mobile_pwd_login")
    public Resp mobilePwdLogin(@RequestBody @Valid MobilePwdLoginReqData mobilePwdLoginReqData) {
        // 提取手机号码
        String mobile = mobilePwdLoginReqData.getMobile();
        // 查询该用户
        User user = userService.getByMobile(mobile);
        // 判断用户是否存在
        if (user == null) {
            // 不存在
            return Resp.error(AppExceptionCodeMsg.COUNTRY_CREDIT_NOT_ENOUTH);
        }
        // 实例化密码哈希
        BCrypt bCrypt = new BCrypt();
        // 判断密码是否正确
        if (!bCrypt.verify_password(mobilePwdLoginReqData.getPassword(), user.getPassword())){
            // 如果不正确
            return Resp.error(AppExceptionCodeMsg.USER_CREDIT_NOT);
        }
        // 生成jwt秘钥
        String jwt_token = Jwt.createToken(user);
        // 返回
        return Resp.success(jwt_token);
    }

    @PutMapping("/mobile_register")
    public Resp addMoBile(@RequestBody @Valid User user ) {


//        if (password != passwords) {
//            Resp.error(AppExceptionCodeMsg.USER_CREDIT_NOT_LU);
//
//        } else {
        try {
            String password = user.getPassword();
            BCrypt bCrypt = new BCrypt();
            String hash = bCrypt.get_password_hash(password);
            user.setPassword(hash);
            String token = Jwt.createToken(user);
            boolean resp = userService.addByMobile(user);
            System.out.println(resp);


            return Resp.success(token);
        }catch (Exception e){
            System.out.println(e);
        }
        return Resp.error(AppExceptionCodeMsg.USER_CREDIT_NOT_LU);
    }
}
