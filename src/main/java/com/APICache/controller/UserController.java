package com.APICache.controller;

import com.APICache.entity.User;
import com.APICache.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    Logger logger= LoggerFactory.getLogger(UserController.class);

    @PostMapping("/add")
    public ResponseEntity<User> saveUSer(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.saveUser(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.ok().body(this.userService.getAllUSer());
    }

    @GetMapping("/{id}")
    @Cacheable(value = "user",key = "#id")
    public User getSingleUser(@PathVariable(value = "id") String id){
        logger.info("Data comes from the database:-");
        return this.userService.getSingleUser(id);
//        return ResponseEntity.status(200).body(this.userService.getSingleUser(id));
    }


    @DeleteMapping("/{id}")
    @CacheEvict(value = "user", allEntries = true)
    public ResponseEntity<String> deleteUSer(@PathVariable String id){
        logger.info("Data comes from the database:-");
        return ResponseEntity.status(200).body(this.userService.deleteUser(id));
    }

    @PutMapping("/{id}")
    @CachePut(value = "user",key = "#id")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") String id,@RequestBody User user){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.userService.updateUser(id,user));

    }

}
