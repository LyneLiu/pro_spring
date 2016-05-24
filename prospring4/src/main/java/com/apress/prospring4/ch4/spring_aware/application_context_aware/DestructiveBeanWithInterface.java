package com.apress.prospring4.ch4.spring_aware.application_context_aware;

import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;

/**
 * Created by nn_liu on 2016/5/24.
 */
public class DestructiveBeanWithInterface {
    private File file;
    private String filePath;

    public void setFilePath(String filePath){
        this.filePath = filePath;
    }

    @PostConstruct
    public void afterPropertiesSet() throws Exception{
        System.out.println("Initializing Bean...");

        if (filePath == null){
            throw new IllegalArgumentException(
                    "You must set the filePath propertity of"+
                    DestructiveBeanWithInterface.class);
        }

        this.file = new File(filePath);
        this.file.createNewFile();
        System.out.println("File exists:"+file.exists());
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Destroy Bean!");

        if (!file.delete()){
            System.err.println("ERROR:failed to delete file.");
        }

        System.out.println("File exists:"+file.exists());

    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:/spring/ch4/spring_aware/app_application_context_aware.xml");
        ctx.registerShutdownHook();
        ctx.refresh();

        DestructiveBeanWithInterface bean = (DestructiveBeanWithInterface) ctx.getBean("destructiveBeanWithInterface");
    }
}
