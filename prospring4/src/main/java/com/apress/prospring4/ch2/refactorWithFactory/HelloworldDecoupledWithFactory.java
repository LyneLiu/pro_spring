package com.apress.prospring4.ch2.refactorWithFactory;

import com.apress.prospring4.ch2.refactorHelloWorld.MessageProvider;
import com.apress.prospring4.ch2.refactorHelloWorld.MessageRender;

/**
 * Created by nn_liu on 2016/4/6.
 */
public class HelloworldDecoupledWithFactory {
    public static void main(String[] args) {
        MessageRender mr = MessageSupportFactory.getInstance().getMessageRender();
        MessageProvider mp = MessageSupportFactory.getInstance().getMessageProvider();
        mr.setMessageProvider(mp);
        mr.render();
    }
}
