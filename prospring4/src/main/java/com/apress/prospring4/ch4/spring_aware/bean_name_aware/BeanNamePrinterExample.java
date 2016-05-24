package com.apress.prospring4.ch4.spring_aware.bean_name_aware;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by nn_liu on 2016/5/24.
 */
public class BeanNamePrinterExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:/spring/ch4/spring_aware/app_bean_aware.xml");
        ctx.refresh();

        BeanNamePrinter printer = (BeanNamePrinter) ctx.getBean("beanNamePrinter");
        printer.someOperation();
    }
}
