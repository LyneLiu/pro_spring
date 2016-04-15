package com.apress.prospring4.ch4.init_method;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by nn_liu on 2016/4/18.
 * 当bean创建的时候调用一个init方法
 */
public class SimpleBean {
    private static final String DEFAULT_NAME = "Luke Skywalker";

    private String name;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /* bean创建时调用的方法
     * 注意：通过IoC方法调用的method不能有参数！！！
     */
    public void init() {
        System.out.println("Initializing bean...");

        if (name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }

        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("You must set the age property of an beans of type " + SimpleBean.class);
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + ";\nAge: " + age;
    }

    private static SimpleBean getBean(String beanName, ApplicationContext ctx){
        try{
            SimpleBean bean = (SimpleBean)ctx.getBean(beanName);
            System.out.println(bean);
            return bean;
        }catch (BeanCreationException ex){
            System.out.println("An error occured in bean configuration: "+ex.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/ch4/app-context-method.xml");
        ctx.refresh();

        SimpleBean simpleBean1 = getBean("simpleBean1",ctx);
        SimpleBean simpleBean2 = getBean("simpleBean2",ctx);
        SimpleBean simpleBean3 = getBean("simpleBean3",ctx);
    }

}
