package com.apress.prospring4.ch3.recapHelloworld;

import com.apress.prospring4.ch3.recapHelloworld.MessageProvider;

/**
 * Created by nn_liu on 2016/4/6.
 */
public interface MessageRenderer {
    void render();
    void setMessageProvider(MessageProvider messageProvider);
    MessageProvider getMessageProvider();
}
