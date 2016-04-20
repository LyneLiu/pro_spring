package com.apress.prospring4.ch4.bean_creation.post_construct;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;

/**
 * Created by nn_liu on 2016/4/18.
 */
public class SimpleBeanWithJSR250 implements InitializingBean{

    private static final String DEFAULT_NAME = "Luke Skywalker";
    private String name;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public void initMethod() {
        System.out.println("bean_method of bean...");
    }

    /*通过注解的方法*/
    @PostConstruct
    public void init() throws Exception {
        System.out.println("Initializing bean");
        if (name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }
        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException(
                    "You must set the age property of any beans of type " +
                            SimpleBeanWithJSR250.class);
        }
    }

    public String toString() {
        return "Name: " + name + "\nAge: " + age;
    }

    private static SimpleBeanWithJSR250 getBean(String beanName, ApplicationContext ctx) {
        try {
            SimpleBeanWithJSR250 bean = (SimpleBeanWithJSR250) ctx.getBean(beanName);
            System.out.println(bean);
            return bean;
        } catch (BeanCreationException ex) {
            System.out.println("An error occured in bean configuration: "
                    + ex.getMessage());
            return null;
        }
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("AfterPropertiesSet of InitializingBean.");
    }

    public static void main(String[] args) {
        /*GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/ch4/app-context-postconstruct.xml");
        ctx.refresh();
        SimpleBeanWithJSR250 simpleBean1 = getBean("simpleBean1", ctx);
        SimpleBeanWithJSR250 simpleBean2 = getBean("simpleBean2", ctx);
        SimpleBeanWithJSR250 simpleBean3 = getBean("simpleBean3", ctx);*/

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/ch4/bean_creation/app-context-interface.xml");
        ctx.refresh();
        SimpleBeanWithJSR250 simpleBean1 = getBean("simpleBean1_1", ctx);
        SimpleBeanWithJSR250 simpleBean2 = getBean("simpleBean2_1", ctx);
        SimpleBeanWithJSR250 simpleBean3 = getBean("simpleBean3_1", ctx);
    }

}
