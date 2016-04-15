package com.apress.prospring4.ch3.injection.methodreplace;

/**
 * Created by nn_liu on 2016/4/15.
 */
public class ReplacementTarget {
    public String formatMessage(String msg) {
        return "<h1>" + msg + "</h1>";
    }
    public String formatMessage(Object msg) {
        return "<h1>" + msg + "</h1>";
    }
}
