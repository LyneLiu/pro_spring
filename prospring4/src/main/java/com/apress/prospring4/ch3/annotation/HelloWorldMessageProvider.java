package com.apress.prospring4.ch3.annotation;

import com.apress.prospring4.ch3.recapHelloworld.MessageProvider;
import org.springframework.stereotype.Service;

/**
 * Created by nn_liu on 2016/4/6.
 */
@Service("messageProvider")
public class HelloWorldMessageProvider implements MessageProvider {
    public String getMessage() {
        return "Hello World!";
    }
}
