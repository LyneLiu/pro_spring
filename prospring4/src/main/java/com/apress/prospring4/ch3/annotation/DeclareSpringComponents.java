package com.apress.prospring4.ch3.annotation;

import com.apress.prospring4.ch3.recapHelloworld.MessageProvider;
import com.apress.prospring4.ch3.recapHelloworld.MessageRenderer;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by nn_liu on 2016/4/6.
 */
public class DeclareSpringComponents {
    public static void main(String[] args) {
        /*通过xml配置文件实现依赖注入*/
        GenericXmlApplicationContext ctx1 = new GenericXmlApplicationContext();
        ctx1.load("classpath:spring/app-context-xml.xml");
        ctx1.refresh();

        MessageProvider messageProvider1 = ctx1.getBean("messageProvider", MessageProvider.class);
        System.out.println(messageProvider1.getMessage());

        MessageRenderer messageRenderer = ctx1.getBean("messageRenderer",MessageRenderer.class);
        messageRenderer.setMessageProvider(messageProvider1);
        messageRenderer.render();

        /*通过注解方式实现依赖注入*/
        GenericXmlApplicationContext ctx2 = new GenericXmlApplicationContext();
        ctx2.load("classpath:spring/app-context-annotation.xml");
        ctx2.refresh();

        MessageProvider messageProvider2 = ctx1.getBean("messageProvider", MessageProvider.class);
        System.out.println(messageProvider2.getMessage());
    }
}
