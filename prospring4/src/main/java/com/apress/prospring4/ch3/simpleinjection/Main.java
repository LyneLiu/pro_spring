package com.apress.prospring4.ch3.simpleinjection;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by nn_liu on 2016/4/11.
 */
public class Main {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-injectionsimple.xml");
        ctx.refresh();

        InjectSimple injectSimple = (InjectSimple)ctx.getBean("injectionSimple");
        System.out.println(injectSimple);
    }
}
