package com.apress.prospring4.ch2.refactorHelloWorld;

import java.util.Scanner;

/**
 * Created by nn_liu on 2016/4/6.
 */
public class CommandLineMessageProvider implements MessageProvider {

    private String message;

    public String getMessage() {
        return commandLineMessage();
    }

    private String commandLineMessage(){
        Scanner scanner = new Scanner(System.in);
        message = scanner.next();
        return message;
    }
}
