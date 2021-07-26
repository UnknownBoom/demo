package com.example.demo.bpp;

import com.example.demo.annotations.RandomValue;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    private Map<String,Class> mappa = new HashMap<>();
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.printf("\n\tBean with name %s before init\n\n",beanName);
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        Arrays.stream(declaredFields).filter(t->t.isAnnotationPresent(RandomValue.class))
                .forEach(t->{t.setAccessible(true);
                    mappa.put(beanName,bean.getClass());
                    ReflectionUtils.setField(t,bean, new Random().nextInt()%100);});

        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        if(mappa.get(beanName) !=null){
//            Class clazz = mappa.get(beanName);
//            return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(),
//                    (proxy, method, args) -> {
//                        System.out.println("Method "+method.getName());
//                        Object result = method.invoke(bean, args);
//                        System.out.println("Method returned "+ result);
//                        return result;
//                    });
//        }
        return bean;

    }
}
