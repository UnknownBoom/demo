package com.example.demo.replacemant;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class UserServiceNewReplacement implements MethodReplacer {

    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("Hello world");
        return null;
    }
}
