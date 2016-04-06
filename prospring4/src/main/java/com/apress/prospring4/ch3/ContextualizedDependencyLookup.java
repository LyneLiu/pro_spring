package com.apress.prospring4.ch3;

/**
 * Created by nn_liu on 2016/4/6.
 */
public class ContextualizedDependencyLookup implements ManagedComponent {
    private Dependency dependency;

    public void performLookup(Container container) {
        this.dependency = (Dependency)container.getDependency("myDependency");
    }

    public String toString(){
        return dependency.toString();
    }
}
