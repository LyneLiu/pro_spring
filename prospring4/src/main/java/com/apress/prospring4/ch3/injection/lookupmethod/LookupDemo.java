package com.apress.prospring4.ch3.injection.lookupmethod;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

/**
 * Created by nn_liu on 2016/4/15.
 */
public class LookupDemo {


    public static void display(DemoBean bean) {
        MyHelper helper1 = bean.getMyHelper();
        MyHelper helper2 = bean.getMyHelper();

        System.out.println("Helper Instances the Same?:"
                + (helper1 == helper2));

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("loopupDemo");

        for (int x = 0;x<100;x++ ){
            MyHelper helper = bean.getMyHelper();
            helper.doSomethingHelpful();
        }

        stopWatch.stop();

        System.out.println("100000 gets took "+stopWatch.getTotalTimeMillis()+" ms");
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-method.xml");
        ctx.refresh();

        /*abstractBean通过method注入的方式，每次都会创建一个新的Bean实例*/
        DemoBean abstractBean = (DemoBean)ctx.getBean("abstractLookupBean");

        /*standardBean通过setter注入的方式，Bean实例只会创建一次*/
        DemoBean standardBean = (DemoBean)ctx.getBean("standardLookupBean");

        display(abstractBean);
        display(standardBean);

    }
}
