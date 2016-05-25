package com.apress.prospring4.ch4.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.security.MessageDigest;

/**
 * Created by nn_liu on 2016/5/25.
 */
public class MessageDigestFactoryBean implements FactoryBean<MessageDigest>,InitializingBean {

    private String algorithmName = "MD5";

    private MessageDigest messageDigest = null;

    public MessageDigest getObject() throws Exception {
        return messageDigest;
    }

    public Class<?> getObjectType() {
        return MessageDigest.class;
    }

    public boolean isSingleton() {
        return false;
    }

    public void afterPropertiesSet() throws Exception {
        messageDigest = MessageDigest.getInstance(algorithmName);
    }

    public void setAlgorithmName(String algorithmName){
        this.algorithmName = algorithmName;
    }
}
