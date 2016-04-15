package com.apress.prospring4.ch3.injection.methodreplace;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * Created by nn_liu on 2016/4/15.
 */
public class FormatMessageReplacer implements MethodReplacer {

    /**
     *
     * @param obj  被调用的Bean
     * @param method  被调用的Bean中的method
     * @param args  传给被调用的Bean的method的参数
     * @return
     * @throws Throwable
     */
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        if (isFormatMessageMethod(method)) {
            String msg = (String) args[0];
            return "<h2>" + msg + "</h2>";
        } else {
            throw new IllegalArgumentException("Unable to reimplement method "
                    + method.getName());
        }
    }

    /*method的一些判断，比如参数个数为1；method名称为formatMessage；返回类型为String；参数类型为String等等*/
    private boolean isFormatMessageMethod(Method method) {
        if (method.getParameterTypes().length != 1) {
            return false;
        }
        if (!("formatMessage".equals(method.getName()))) {
            return false;
        }
        if (method.getReturnType() != String.class) {
            return false;
        }
        if (method.getParameterTypes()[0] != String.class) {
            return false;
        }
        return true;
    }
}
