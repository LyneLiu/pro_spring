package com.apress.prospring4.ch3.annotation;

import com.apress.prospring4.ch3.recapHelloworld.MessageProvider;

/**
 * Created by nn_liu on 2016/4/7.
 */
public class ConfigurableMessageProvider implements MessageProvider {

    private String message;

    public ConfigurableMessageProvider(String message){
        this.message=message;
    }

    public String getMessage() {
        return this.message;
    }
}
