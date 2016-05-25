package com.apress.prospring4.ch4.factorybean;

import java.security.MessageDigest;

/**
 * Created by nn_liu on 2016/5/25.
 */
public class MessageDigester {
    private MessageDigest digest1;
    private MessageDigest digest2;

    public void setDigest1(MessageDigest digest1){
        this.digest1 = digest1;
    }

    public void setDigest2(MessageDigest digest2) {
        this.digest2 = digest2;
    }

    public void digest(String msg){
        System.out.println("Using digest1:");
        digest(msg,digest1);

        System.out.println("Using digest2:");
        digest(msg,digest2);
    }

    public void digest(String msg,MessageDigest digest){
        System.out.println("Using algorithm: "+digest.getAlgorithm());
        digest.reset();
        byte[] bytes = msg.getBytes();
        byte[] out = digest.digest(bytes);
        System.out.println(out);
    }
}
