package com.gerald.jvm.chapter7.loadclass;

public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init");
    }
}
