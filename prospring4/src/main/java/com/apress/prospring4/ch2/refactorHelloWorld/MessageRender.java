package com.apress.prospring4.ch2.refactorHelloWorld;

/**
 * Created by nn_liu on 2016/4/6.
 */
public interface MessageRender {
    void render();
    void setMessageProvider(MessageProvider provider);
    MessageProvider getMessageProvider();
}
