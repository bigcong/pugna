package com.cc.service;

import java.util.List;

import com.cc.entity.User;

public interface UserService {
    List<User> listPageUser(User paramUser);

    Integer getUserCount();

    Integer insertUser(User paramUser);

    User getUserById(Integer paramInteger);

    User getUser(User paramUser);

    void updateUser(User paramUser);

    void deleteUser(User paramUser);

    void deleteUserByIds(String[] paramArrayOfString);
}