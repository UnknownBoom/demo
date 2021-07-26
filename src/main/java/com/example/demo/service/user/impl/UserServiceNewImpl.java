package com.example.demo.service.user.impl;


import com.example.demo.annotations.PostProxy;
import com.example.demo.dao.UserDao;
import com.example.demo.domain.model.User;
import com.example.demo.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class UserServiceNewImpl extends UserServiceImpl implements UserService {
    private final List<UserService> userServices;

    public UserServiceNewImpl(UserDao userDao, @Lazy List<UserService> userServices) {
        super(userDao);
        this.userServices = userServices;
    }


    @Override
    public void postConstructMethod()  {
        try {
            this.rand = 4;
            System.out.println(this.getClass().getField("rand"));
        } catch (NoSuchFieldException e) {
            System.out.println("Filed rand not found");
        }
        for (Field declaredField : this.getClass().getFields()) {
            System.out.println(Arrays.toString(declaredField.getAnnotations()));
        }
        log.info("-----Start (2) ---- " + this.rand + " ----");
    }

    @Override
    public User findUserById(Long id) {
        return super.findUserById(id);
    }

    @Override
    @PostProxy
    public void postProxyMethod() {
        userServices.forEach(t-> System.out.println(t.getClass().getName()));
        log.info("------------Post proxy 2-------------");
    }
}
