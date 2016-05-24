package com.apress.prospring4.ch4.spring_aware.bean_name_aware;

import org.springframework.beans.factory.BeanNameAware;

/**
 * Created by nn_liu on 2016/5/24.
 */
public class BeanNamePrinter implements BeanNameAware {

    private String beanName = null;

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public void someOperation(){
        System.out.println("Bean ["+beanName+"] - someOperation()");
    }
}
