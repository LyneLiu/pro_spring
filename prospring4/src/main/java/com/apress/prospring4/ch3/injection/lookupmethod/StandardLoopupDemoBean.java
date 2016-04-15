package com.apress.prospring4.ch3.injection.lookupmethod;

/**
 * Created by nn_liu on 2016/4/15.
 */
public class StandardLoopupDemoBean implements DemoBean {

    private MyHelper myHelper;

    public void setMyHelper(MyHelper myHelper) {
        this.myHelper = myHelper;
    }

    public MyHelper getMyHelper() {
        return this.myHelper;
    }

    public void someOperation() {
        myHelper.doSomethingHelpful();
    }
}
