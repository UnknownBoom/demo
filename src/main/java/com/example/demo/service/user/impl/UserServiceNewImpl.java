package com.example.demo.service.user.impl;


import com.example.demo.domain.model.User;
import com.example.demo.service.user.UserService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Arrays;

@Service
public class UserServiceNewImpl extends UserServiceImpl implements UserService {
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
        System.out.println("-----Start (2) ---- " + this.rand + " ----");
    }

    @Override
    public User findUserById(Long id) {
        return new User(){{setId(42L);}};
    }
}
