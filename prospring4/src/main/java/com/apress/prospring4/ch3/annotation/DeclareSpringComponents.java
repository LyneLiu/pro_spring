package com.apress.prospring4.ch3.annotation;

import com.apress.prospring4.ch3.recapHelloworld.MessageProvider;
import com.apress.prospring4.ch3.recapHelloworld.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by nn_liu on 2016/4/6.
 */
public class DeclareSpringComponents {
    public static void main(String[] args) {
        /*通过xml配置文件实现Setter方式依赖注入*/
        GenericXmlApplicationContext ctx1 = new GenericXmlApplicationContext();
        ctx1.load("classpath:spring/app-context-setter.xml");
        ctx1.refresh();

        MessageProvider messageProvider1 = ctx1.getBean("messageProvider", MessageProvider.class);
        System.out.println(messageProvider1.getMessage());

        MessageRenderer messageRenderer1 = ctx1.getBean("messageRenderer",MessageRenderer.class);
        messageRenderer1.setMessageProvider(messageProvider1);
        messageRenderer1.render();


         /*通过xml配置文件实现Constructor方式依赖注入*/
        ApplicationContext ctx2 = new ClassPathXmlApplicationContext("classpath:spring/ch3/app-context-constructor.xml");


        MessageProvider messageProvider2 = ctx2.getBean("messageProvider", MessageProvider.class);
        System.out.println(messageProvider2.getMessage());

        MessageRenderer messageRenderer2 = ctx2.getBean("messageRenderer",MessageRenderer.class);
        messageRenderer2.setMessageProvider(messageProvider2);
        messageRenderer2.render();

        /*通过注解方式实现依赖注入*/
        GenericXmlApplicationContext ctx3 = new GenericXmlApplicationContext();
        ctx3.load("classpath:spring/app-context-annotation.xml");
        ctx3.refresh();

        MessageProvider messageProvider3 = ctx3.getBean("messageProvider", MessageProvider.class);
        System.out.println(messageProvider3.getMessage());

    }
}
