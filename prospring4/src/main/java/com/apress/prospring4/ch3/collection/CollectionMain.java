package com.apress.prospring4.ch3.collection;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by nn_liu on 2016/4/13.
 */
public class CollectionMain {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-collection.xml");
        ctx.refresh();

        CollectionInjection collectionInjection = (CollectionInjection) ctx.getBean("injectionCollection");
        collectionInjection.displayInfo();
    }
}
