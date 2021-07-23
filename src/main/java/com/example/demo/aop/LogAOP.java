package com.example.demo.aop;

import com.example.demo.excep.MyExep;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
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

    @Around("logPointcut()")
    public Object doAroundLog(ProceedingJoinPoint pjp) throws Throwable {
        try {
            Object proceed = pjp.proceed();
            return proceed;
        } catch (MyExep throwable) {
            throwable.printStackTrace();
            throwable.setMessage("throw");
            throw throwable;
        }

    }


}
