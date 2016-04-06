package com.apress.prospring4.ch3.recapHelloworld;

/**
 * Created by nn_liu on 2016/4/6.
 */
class StandardOutMessageRenderer implements MessageRenderer {
    private MessageProvider messageProvider;

    public void render() {
        if (messageProvider == null){
            throw new RuntimeException("You must set the property messageProvider of class:"
                    +StandardOutMessageRenderer.class.getName());
        }

        System.out.println(messageProvider.getMessage());
    }

    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider= messageProvider;
    }

    public MessageProvider getMessageProvider() {
        return messageProvider;
    }
}
