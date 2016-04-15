package com.apress.prospring4.ch3.base;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by nn_liu on 2016/4/15.
 * Spring中别名的使用
 */

public class Alias {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context.xml");
        ctx.refresh();

        String s1 = (String)ctx.getBean("name1");
        String s2 = (String)ctx.getBean("name2");
        String s3 = (String)ctx.getBean("name3");
        String s4 = (String)ctx.getBean("name4");
        String s5 = (String)ctx.getBean("name5");
        String s6 = (String)ctx.getBean("name6");

        System.out.println(s1.equals(s2));
        System.out.println(s2.equals(s3));
        System.out.println(s3.equals(s4));
        System.out.println(s4.equals(s5));
        System.out.println(s5.equals(s6));

        /*可以通过ApplicationContext.getAliases(String)的方法获取别名的相关信息*/
        String[] strings = ctx.getAliases("name1");
        for (String str:strings) {
            System.out.println(str);
        }
    }
}
