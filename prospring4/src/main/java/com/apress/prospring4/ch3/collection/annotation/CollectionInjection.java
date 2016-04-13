package com.apress.prospring4.ch3.collection.annotation;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by nn_liu on 2016/4/13.
 */
@Service("injectionCollection")
public class CollectionInjection {

    @Resource(name="map")
    private Map<String,Object> map;
    @Resource(name="props")
    private Properties props;
    @Resource(name="set")
    private Set set;
    @Resource(name="list")
    private List list;

    public void displayInfo(){
        System.out.println("Map contents:\n");

        for (Map.Entry<String,Object> entry:map.entrySet()){
            System.out.println("Key: "+entry.getKey()+"- Value: "+entry.getValue());
        }

        System.out.println("\nProperties contents:\n");

        for (Map.Entry<Object,Object> entry:props.entrySet()) {
            System.out.println("Key: "+entry.getKey()+"- Value: "+entry.getValue());
        }

        System.out.println("\nSet contents:\n");

        for (Object obj:set) {
            System.out.println("Value: "+obj);
        }

        System.out.println("\nList contents:\n");

        for (Object obj:list) {
            System.out.println("Value: "+obj);
        }
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-collection.xml");
        ctx.refresh();

        com.apress.prospring4.ch3.collection.CollectionInjection collectionInjection = (com.apress.prospring4.ch3.collection.CollectionInjection) ctx.getBean("injectionCollection");
        collectionInjection.displayInfo();
    }
}