package com.apress.prospring4.ch2.refactorHelloWorld;

/**
 * Created by nn_liu on 2016/4/6.
 */
public class StandardOutMessageRenderer implements MessageRender {

    private MessageProvider messageProvider;

    public void render() {
        if (messageProvider == null){
            throw new RuntimeException(
                    "You must set the property messageProvider of class:"
                     +StandardOutMessageRenderer.class.getName());
        }

        System.out.println(messageProvider.getMessage());
    }

    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;
    }

    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
