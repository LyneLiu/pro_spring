package com.apress.prospring4.ch4.spring_aware.application_context_aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericApplicationContext;

import javax.annotation.PreDestroy;

/**
 * Created by nn_liu on 2016/5/24.
 */
public class ShutdownHookBean implements ApplicationContextAware {

    private ApplicationContext ctx;

    /**
     *
     * @param applicationContext
     * @throws BeansException
     */
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        try{
            if (ctx instanceof GenericApplicationContext){
                ((GenericApplicationContext) ctx).registerShutdownHook();
            }
        }catch (BeansException e){
            throw e;
        }
    }


}
