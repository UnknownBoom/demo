package com.example.demo.config;

import com.example.demo.replacemant.UserServiceNewReplacement;
import com.example.demo.service.user.UserService;
import com.example.demo.service.user.impl.UserServiceNewImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Iterator;
import java.util.List;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig  {
//    @Bean
//    public UserService UserServiceNewImpl(){
//        return new UserServiceNewImpl() {
//            @Override
//            public void sayHello() {
//                new UserServiceNewReplacement().reimplement();
//            }
//        }
//    }
}
