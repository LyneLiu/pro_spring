package com.apress.prospring4.ch3.dependencyinjection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by nn_liu on 2016/4/6.
 */

/*BeanFactory是container，
  通过XML配置文件进行依赖注入的实现，
  然后从BeanFactory中读取bean数据*/
public class XmlConfigWithBeanFactory {
    public static void main(String[] args) {

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader rdr = new XmlBeanDefinitionReader(factory);
        /*注：classpath方法访问的方式不需要添加classpath*：等信息*/
        rdr.loadBeanDefinitions(new ClassPathResource("spring/xml-bean-factory-config.xml"));

        Oracle oracle = (Oracle)factory.getBean("oracle");

        System.out.println(oracle.defineMeaningOfLife());
    }
}
