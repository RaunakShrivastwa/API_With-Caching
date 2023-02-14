package com.APICache.service;

import com.APICache.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    List<User> getAllUSer();

    User getSingleUser(String id);

    String deleteUser(String id);

    User updateUser(String id,User user);
}
