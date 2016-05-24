package com.apress.prospring4.ch2.refactorWithFactory;

import com.apress.prospring4.ch2.refactorHelloWorld.MessageProvider;
import com.apress.prospring4.ch2.refactorHelloWorld.MessageRender;

import java.net.URL;

/**
 * Created by nn_liu on 2016/4/6.
 */
public class HelloworldDecoupledWithFactory {

    public void pathFunc(){
        URL basePath = this.getClass().getResource("");
        System.out.println(basePath);
    }

    public static void main(String[] args) {
        /*MessageRender mr = MessageSupportFactory.getInstance().getMessageRender();
        MessageProvider mp = MessageSupportFactory.getInstance().getMessageProvider();
        mr.setMessageProvider(mp);
        mr.render();*/

        HelloworldDecoupledWithFactory decoupledWithFactory = new HelloworldDecoupledWithFactory();
        decoupledWithFactory.pathFunc();
    }
}
