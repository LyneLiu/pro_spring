package com.apress.prospring4.ch4.accessing_factorybean;

import com.apress.prospring4.ch4.factorybean.MessageDigestFactoryBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.security.MessageDigest;

/**
 * Created by nn_liu on 2016/5/25.
 */
public class AccessingFactoryBeans {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:/spring/ch4/factory_bean/app_factory_bean.xml");
        ctx.refresh();

        /*1、“&”符号表示要获取的是一个FactoryBean
         *2、当不使用“&”并且在获取得到的是FactoryBean实例的情况下，Spring会通过处理机制获取一个FactoryBean中包含的Bean
         */
        MessageDigestFactoryBean digestFactoryBean = (MessageDigestFactoryBean) ctx.getBean("&shaDigest");

        try{
            MessageDigest shaDigest = digestFactoryBean.getObject();
            System.out.println(shaDigest.digest("Hello World!".getBytes()));

            String[] beans = ctx.getBeanDefinitionNames();
            for (String bean:beans) {
                System.out.println(bean);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
