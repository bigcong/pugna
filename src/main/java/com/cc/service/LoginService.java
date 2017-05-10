package com.cc.service;

import java.util.List;

import com.cc.entity.Menu;
import com.cc.entity.User;

public interface LoginService {
    User getUser(String userName, String password);

    List<Menu> ListMenuByUserId(User user);

}
