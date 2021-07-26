package com.example.demo.context;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@Component
public class Context {

    @PostConstruct
    public void postConstructMethod(){
    }
}
