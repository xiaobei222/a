package com.anydoortrip.anydoortrip.apps.user.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    private String username;

    private String lastName;

    private String firstName;

    private String mobilePhone;

    private String email;

    private String openid;

    private String password;

    private String profilePhoto;

    private Integer gender;

    private LocalDate birthday;

    private int superUser;
    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    private int level;

    private String phoneCountryCode;
}
