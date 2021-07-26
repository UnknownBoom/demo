package com.example.demo.AppListener;

import com.example.demo.annotations.PostProxy;
import lombok.RequiredArgsConstructor;
import org.hibernate.event.spi.RefreshEventListener;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.Arrays;
@Component
@RequiredArgsConstructor
public class RefreshAppListener implements ApplicationListener<ContextRefreshedEvent> {
    private final ConfigurableListableBeanFactory configurableListableBeanFactory;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ApplicationContext context = contextRefreshedEvent.getApplicationContext();
        String[] beanNamesForAnnotation = context.getBeanNamesForAnnotation(Service.class);
        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(beanName);
            try {
                if(beanDefinition.getBeanClassName() == null) continue;
                Class<?> aClass = Class.forName(beanDefinition.getBeanClassName());
                for (Method declaredMethod : aClass.getDeclaredMethods()) {
                    if(declaredMethod.isAnnotationPresent(PostProxy.class)){
                        System.out.println(aClass);
                        Object bean = context.getBean(beanName, aClass);

                        Method method = bean.getClass().getMethod(declaredMethod.getName(), declaredMethod.getParameterTypes());
                        method.invoke(bean);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
