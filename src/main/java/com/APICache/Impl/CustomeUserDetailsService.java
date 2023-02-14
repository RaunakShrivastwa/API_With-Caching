package com.APICache.Impl;

import com.APICache.entity.CustomeUserDetails;
import com.APICache.entity.User;
import com.APICache.repositery.UserRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class CustomeUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepositery userRepositery;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userInfo = Optional.ofNullable(this.userRepositery.findByEmail(email));
        return userInfo.map(CustomeUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + email));
    }
}
