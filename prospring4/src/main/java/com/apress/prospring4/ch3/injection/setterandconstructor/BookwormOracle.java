package com.apress.prospring4.ch3.injection.setterandconstructor;

/**
 * Created by nn_liu on 2016/4/6.
 */
public class BookwormOracle implements Oracle{
    private Encyclopedia encyclopedia;

    public void setEncyclopedia(Encyclopedia encyclopedia){
        this.encyclopedia=encyclopedia;
    }

    public String defineMeaningOfLife() {
        return "Encyclopedias are a waste of life - use the internet.";
    }
}
