package com.APICache.repositery;

import com.APICache.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositery extends JpaRepository<User,String> {

    User findByEmail(String email);

}
