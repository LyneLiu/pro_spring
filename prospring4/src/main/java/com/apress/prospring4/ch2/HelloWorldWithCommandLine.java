package com.apress.prospring4.ch2;

/**
 * Created by nn_liu on 2016/4/6.
 */
/*可以根据用户的输入显示输出结果，增强可用性*/
public class HelloWorldWithCommandLine {
    public static void main(String[] args) {
        if (args.length > 0){
            for (String arg:args
                 ) {
                System.out.print(arg+" ");
            }
        }else {
            System.out.println("Hello Wrold!");
        }
    }
}
