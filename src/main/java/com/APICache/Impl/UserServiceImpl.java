package com.APICache.Impl;

import com.APICache.entity.User;
import com.APICache.repositery.UserRepositery;
import com.APICache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepositery userRepositery;
    @Override
    public User saveUser(User user) {
        user.setId(UUID.randomUUID().toString());
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepositery.save(user);
    }

    @Override
    public List<User> getAllUSer() {
        return userRepositery.findAll();
    }

    @Override
    public User getSingleUser(String id) {
        return userRepositery.findById(id).get();
    }

    @Override
    public String deleteUser(String id) {
        userRepositery.deleteById(id);
        return "User Deleted with id:-"+id;
    }

    @Override
    public User updateUser(String id,User user) {
      User user1= userRepositery.findById(id).get();
      user1.setName(user.getName());
      user1.setEmail(user.getEmail());

        return user1;
    }
}
