package com.apress.prospring4.ch2.refactorHelloWorld;

/**
 * Created by nn_liu on 2016/4/6.
 */
public class HelloWorldMessageProvider implements MessageProvider {
    public String getMessage() {
        return "Hello World!";
    }
}
