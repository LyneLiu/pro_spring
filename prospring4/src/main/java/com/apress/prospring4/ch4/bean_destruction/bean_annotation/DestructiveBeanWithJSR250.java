package com.apress.prospring4.ch4.bean_destruction.bean_annotation;

import com.apress.prospring4.ch4.bean_destruction.bean_interface.DestructiveBeanWithInterface;
import com.apress.prospring4.ch4.bean_destruction.bean_method.DestructiveBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.IOException;

/**
 * Created by nn_liu on 2016/4/20.
 * 注解需要注意的地方是在Spring配置文件中启动注解配置
 */
public class DestructiveBeanWithJSR250 {

    private File file;
    private String filePath;

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @PostConstruct
    public void afterPropertiesSet() throws IOException {
        System.out.println("Initializing Bean with annotation...");

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
        System.out.println("Destroying Bean with annotation...");

        if (!file.delete()){
            System.err.println("ERROR:failed to delete file.");
        }

        System.out.println("File exists:"+file.exists());
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/ch4/bean_destruction/app_context_annotation.xml");
        ctx.refresh();

        DestructiveBeanWithJSR250 bean = (DestructiveBeanWithJSR250)ctx.getBean("destructiveBean");

        System.out.println("Calling destroy()");
        ctx.destroy();
        System.out.println("Called destroy()");
    }

}
