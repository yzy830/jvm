package com.gerald.jvm.chapter7.loadclass;

public class NonInitialization {
    public static void main(String[] args) {
        System.out.println(SubClass.str);
        Integer.valueOf(2);
        System.out.println(SubClass.value);
    }
}
