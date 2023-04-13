package com.anydoortrip.anydoortrip.apps.user.service;

import com.anydoortrip.anydoortrip.apps.user.pojo.User;

import java.util.List;

public interface UserService {
    List<User> getById(Integer id);
}
