package com.apress.prospring4.ch2.refactorWithFactory;

import com.apress.prospring4.ch2.refactorHelloWorld.MessageProvider;
import com.apress.prospring4.ch2.refactorHelloWorld.MessageRender;

import java.io.FileInputStream;
import java.rmi.server.ExportException;
import java.util.Properties;

/**
 * Created by nn_liu on 2016/4/6.
 */

/*通过配置文件设置消息实例
  问题1：需要写Properties等glue code
  问题2：需要手动实现MessageRender和MessageProvider的实例
 */

public class MessageSupportFactory {
    private static MessageSupportFactory instance;

    private Properties props;
    private MessageRender render;
    private MessageProvider provider;

    static {
        instance = new MessageSupportFactory();
    }

    private MessageSupportFactory(){
        props = new Properties();

        try{

            props.load(new FileInputStream("src/main/resources/spring/ch2/msf.properties"));

            String renderClass = props.getProperty("renderer.class");
            String providerClass = props.getProperty("provider.class");

            render = (MessageRender)Class.forName(renderClass).newInstance();
            provider = (MessageProvider) Class.forName(providerClass).newInstance();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static MessageSupportFactory getInstance(){
        return instance;
    }

    public MessageRender getMessageRender(){
        return render;
    }

    public MessageProvider getMessageProvider(){
        return provider;
    }
}
