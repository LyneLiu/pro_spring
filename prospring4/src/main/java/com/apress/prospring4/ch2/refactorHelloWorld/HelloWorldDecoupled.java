package com.apress.prospring4.ch2.refactorHelloWorld;

/**
 * Created by nn_liu on 2016/4/6.
 */
public class HelloWorldDecoupled {
    public static void main(String[] args) {
        /*实现1*/
        MessageRender mr = new StandardOutMessageRenderer();
        MessageProvider messageProvider1 = new HelloWorldMessageProvider();
        mr.setMessageProvider(messageProvider1);
        mr.render();

        /*实现1*/
        MessageProvider messageProvider2=new CommandLineMessageProvider();
        mr.setMessageProvider(messageProvider2);
        mr.render();
    }
}
