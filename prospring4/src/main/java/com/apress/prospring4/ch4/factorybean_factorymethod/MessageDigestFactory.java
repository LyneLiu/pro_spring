package com.apress.prospring4.ch4.factorybean_factorymethod;

import java.security.MessageDigest;

/**
 * Created by nn_liu on 2016/5/26.
 */
public class MessageDigestFactory {

    private String algorithmName = "MD5";

    public MessageDigest createInstance() throws  Exception{
        return MessageDigest.getInstance(algorithmName);
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

}
