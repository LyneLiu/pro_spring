package com.apress.prospring4.ch3.base;

/**
 * Created by nn_liu on 2016/4/6.
 */
public class ConstructorInjection {
    private Dependency dependency;

    public ConstructorInjection(Dependency dependency){
        this.dependency=dependency;
    }

    public String toString(){
        return dependency.toString();
    }
}
