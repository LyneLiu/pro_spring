package com.apress.prospring4.ch4.factorybean;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by nn_liu on 2016/5/25.
 */
public class MessageDigestExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:/spring/ch4/factory_bean/app_factory_bean.xml");
        ctx.refresh();

        MessageDigester digester = (MessageDigester) ctx.getBean("digester");
        digester.digest("Hello Spring World!");
    }
}
