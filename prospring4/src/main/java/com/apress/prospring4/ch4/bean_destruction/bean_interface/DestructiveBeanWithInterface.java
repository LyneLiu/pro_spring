package com.apress.prospring4.ch4.bean_destruction.bean_interface;

import com.apress.prospring4.ch4.bean_destruction.bean_method.DestructiveBean;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.File;

/**
 * Created by nn_liu on 2016/4/20.
 * 1、InitializingBean实现Bean初始化的callback函数
 * 2、DisposableBean实现Bean在destroy时的函数
 */
public class DestructiveBeanWithInterface implements InitializingBean,DisposableBean {

    private File file;
    private String filePath;

    public void destroy() throws Exception {
        System.out.println("Destroying Bean with interface...");

        if (!file.delete()){
            System.err.println("ERROR: failed to deleta file.");
        }

        System.out.println("File exists:"+file.exists());
    }

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

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/ch4/bean_destruction/app_context_interface.xml");
        ctx.refresh();

        DestructiveBeanWithInterface bean = (DestructiveBeanWithInterface)ctx.getBean("destructiveBean");

        System.out.println("Calling destroy()");
        ctx.destroy();
        System.out.println("Called destroy()");
    }

}
