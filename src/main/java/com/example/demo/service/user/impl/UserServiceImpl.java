package com.example.demo.service.user.impl;

import com.example.demo.annotations.DeprecatedClass;
import com.example.demo.annotations.PostProxy;
import com.example.demo.annotations.RandomValue;
import com.example.demo.dao.UserDao;
import com.example.demo.domain.model.User;
import com.example.demo.excep.MyExep;
import com.example.demo.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Collection;

@Service
@Lazy
@Primary
@DeprecatedClass(newClass = UserServiceNewImpl.class)
@RequiredArgsConstructor
public  class UserServiceImpl implements UserService {
    private final UserDao userDao;
    @RandomValue
    protected int rand =3;

    @ManagedAttribute
    public int getRand() {
        return rand;
    }

    @Override
    @Cacheable
    public User findUserById(Long id) {
//        throw new MyExep("tes");
        System.out.println(rand);
        User user = userDao.findById(id).orElse(null);
        return user;
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
    public void preDestroyMethod(){
        System.out.println(rand);
        System.out.println("-----Exit------------------");
    }


    public void postConstructMethod(){
        System.out.println("-----Start (1) ---- " + rand + " ----");
    }
    @PostProxy
    public void postProxyMethod(){
        System.out.println("-----PostProxy------------");
    }


}
