package com.apress.prospring4.ch3.base;

import com.apress.prospring4.ch2.refactorHelloWorld.MessageRender;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by nn_liu on 2016/4/6.
 */
public class DependencyPull {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/app-context.xml");

        MessageRender messageRender = ctx.getBean("renderer",MessageRender.class);
        messageRender.render();
    }
}
