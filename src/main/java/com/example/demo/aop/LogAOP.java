package com.example.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class LogAOP {
    @Pointcut("execution(* *(..)) && within(com.example..*)")
    private void logPointcut(){}

    @Before("logPointcut()")
    public void doLogBefore(){
//        log.info("Succs");
    }
}
