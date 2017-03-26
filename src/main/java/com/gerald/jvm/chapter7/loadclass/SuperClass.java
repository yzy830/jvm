package com.gerald.jvm.chapter7.loadclass;

public class SuperClass {    
    public final static int value = 0x3322ff00;
    
    public static String str = "super class";
    
    static {
        System.out.println("superClass init");
        str = "123";
        System.out.println(str);
    }
}
