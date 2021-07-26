package com.example.demo.bfpp;

import com.example.demo.annotations.DeprecatedClass;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        String[] beanDefinitionNames = configurableListableBeanFactory.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(beanDefinitionName);
            String beanClassName = beanDefinition.getBeanClassName();
            if(beanClassName==null) continue;
            try {
                Class<?> aClass = Class.forName(beanClassName);
                DeprecatedClass annotation = aClass.getAnnotation(DeprecatedClass.class);
                if(annotation!=null){
                    beanDefinition.setBeanClassName(annotation.newClass().getName());
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
}
