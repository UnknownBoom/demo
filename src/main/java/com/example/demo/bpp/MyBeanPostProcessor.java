package com.example.demo.bpp;

import com.example.demo.annotations.RandomValue;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Random;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.printf("\n\tBean with name %s before init\n\n",beanName);
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        Arrays.stream(declaredFields).filter(t->t.isAnnotationPresent(RandomValue.class))
                .forEach(t->{t.setAccessible(true);
                    ReflectionUtils.setField(t,bean, new Random().nextInt()%100);});

        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

}
