package com.anydoortrip.anydoortrip.apps.user.service;

import com.anydoortrip.anydoortrip.apps.user.pojo.User;
import com.anydoortrip.anydoortrip.apps.utlis.Resp;

import java.util.List;

public interface UserService {
    User getById(Integer id);

    User getByMobile(String mobile);

    boolean addByMobile(User user);
}
