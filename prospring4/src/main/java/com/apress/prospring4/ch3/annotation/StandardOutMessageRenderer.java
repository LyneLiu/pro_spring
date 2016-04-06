package com.apress.prospring4.ch3.annotation;

import com.apress.prospring4.ch3.recapHelloworld.MessageProvider;
import com.apress.prospring4.ch3.recapHelloworld.MessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by nn_liu on 2016/4/6.
 */
@Service("messageRenderer")
class StandardOutMessageRenderer implements MessageRenderer {
    private MessageProvider messageProvider;

    public void render() {
        if (messageProvider == null){
            throw new RuntimeException("You must set the property messageProvider of class:"
                    +StandardOutMessageRenderer.class.getName());
        }

        System.out.println(messageProvider.getMessage());
    }

    /*
    注解的方式实现Setter依赖注入
    方法1：@Autowired
    方法2：@Resource(name="messageProvider")*/
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider= messageProvider;
    }

    public MessageProvider getMessageProvider() {
        return messageProvider;
    }
}
