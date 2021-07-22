package com.example.demo.service.user.impl;

import com.example.demo.annotations.RandomValue;
import com.example.demo.domain.model.User;
import com.example.demo.service.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {
    @RandomValue
    private int rand;
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

    @PreDestroy
    public void test(){
        System.out.println(rand);
        System.out.println("-----Exit------------------");
    }
    @PostConstruct
    public void init(){
        System.out.println(rand);
        System.out.println("-----Start--------------");
    }
}
