package com.apress.prospring4.ch4.bean_destruction.bean_method;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.File;

/**
 * Created by nn_liu on 2016/4/20.
 */
public class DestructiveBean implements InitializingBean {

    private File file;
    private String filePath;

    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing Bean with interface...");

        if (filePath == null){
            throw new IllegalArgumentException("" +
                    "You must specify the filePath property of "+DestructiveBean.class);
        }

        this.file = new File(filePath);
        this.file.createNewFile();

        System.out.println("File exists:"+file.exists());
    }

    public void destroy(){
        System.out.println("Destroying Bean with method...");

        if (!file.delete()){
            System.err.println("ERROR: failed to deleta file.");
        }

        System.out.println("File exists:"+file.exists());
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/ch4/bean_destruction/app_context_method.xml");
        ctx.refresh();

        DestructiveBean bean = (DestructiveBean)ctx.getBean("destructiveBean");

        System.out.println("Calling destroy()");
        ctx.destroy();
        System.out.println("Called destroy()");
    }
}
