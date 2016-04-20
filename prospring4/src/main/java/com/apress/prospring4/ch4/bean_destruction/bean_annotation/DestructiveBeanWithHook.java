package com.apress.prospring4.ch4.bean_destruction.bean_annotation;

import com.apress.prospring4.ch4.bean_destruction.bean_method.DestructiveBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.IOException;

/**
 * Created by nn_liu on 2016/4/20.
 */
public class DestructiveBeanWithHook {
    private File file;
    private String filePath;

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @PostConstruct
    public void afterPropertiesSet() throws IOException {
        System.out.println("Initializing Bean with hook...");

        if (filePath == null){
            throw new IllegalArgumentException("" +
                    "You must specify the filePath property of "+DestructiveBean.class);
        }

        this.file = new File(filePath);
        this.file.createNewFile();

        System.out.println("File exists:"+file.exists());
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Destroying Bean with hook...");

        if (!file.delete()){
            System.err.println("ERROR:failed to delete file.");
        }

        System.out.println("File exists:"+file.exists());
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/ch4/bean_destruction/app_context_annotation.xml");
        ctx.registerShutdownHook();
        ctx.refresh();

        DestructiveBeanWithHook bean = (DestructiveBeanWithHook)ctx.getBean("destructiveBeanWithHook");
    }
}
