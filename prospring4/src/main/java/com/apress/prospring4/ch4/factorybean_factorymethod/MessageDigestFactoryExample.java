package com.apress.prospring4.ch4.factorybean_factorymethod;

import com.apress.prospring4.ch4.factorybean.MessageDigester;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by nn_liu on 2016/5/26.
 */
public class MessageDigestFactoryExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:/spring/ch4/factory_bean/app-factorybean-context.xml");
        ctx.refresh();

        MessageDigester digester = (MessageDigester) ctx.getBean("digesterTest");
        digester.digest("Hello Spring World!");
    }
}
