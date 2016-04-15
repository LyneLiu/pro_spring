package com.apress.prospring4.ch4.bean_interface;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by nn_liu on 2016/4/18.
 * 通过InitializingBean接口实现Bean方法
 */
public class SimpleBeanWithInterface implements InitializingBean {

    private static final String DEFAULT_NAME = "Luke Skywalker";

    private String name;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void myInit() {
        System.out.println("My Init!");
    }


    public String toString() {
        return "Name: " + name + "\nAge: " + age;
    }


    private static SimpleBeanWithInterface getBean(String beanName,
                                                   ApplicationContext ctx) {
        try {
            SimpleBeanWithInterface bean = (SimpleBeanWithInterface) ctx.getBean(beanName);
            System.out.println(bean);
            return bean;
        } catch (BeanCreationException ex) {
            System.out.println("An error occured in bean configuration: "
                    + ex.getMessage());
            return null;
        }
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing bean");
        if (name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }
        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException(
                    "You must set the age property of any beans of type " +
                            SimpleBeanWithInterface.class);
        }
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/ch4/app-context-interface.xml");
        ctx.refresh();
        SimpleBeanWithInterface simpleBean1 = getBean("simpleBean1", ctx);
        SimpleBeanWithInterface simpleBean2 = getBean("simpleBean2", ctx);
        SimpleBeanWithInterface simpleBean3 = getBean("simpleBean3", ctx);
    }


}
