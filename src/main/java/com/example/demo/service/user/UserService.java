package com.example.demo.service.user;

import com.example.demo.domain.model.User;


import java.util.Collection;
import java.util.Optional;

public interface UserService{
    User findUserById(Long id);
    Collection<User> findAllUsers();
    User saveUser(User user);
}
