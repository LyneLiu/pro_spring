package com.apress.prospring4.ch2.refactorWithSpring;

import com.apress.prospring4.ch2.refactorHelloWorld.MessageRender;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by nn_liu on 2016/4/6.
 */
/*Spring的ApplicationContext可以替代MessageSupportFactory*/
public class HelloWorldSpringDI {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/ch2/app-context.xml");

        MessageRender mr = ctx.getBean("renderer",MessageRender.class);
        mr.render();
    }
}
