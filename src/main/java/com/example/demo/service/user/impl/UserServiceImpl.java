package com.example.demo.service.user.impl;

import com.example.demo.domain.model.User;
import com.example.demo.service.user.UserService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User findUserById(Long id) {
        return null;
    }

    @Override
    public Collection<User> findAllUsers() {
        return null;
    }

    @Override
    public User saveUser(User user) {
        return null;
    }
}
