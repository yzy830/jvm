package com.gerald.jvm.chapter7.classloader;

public class Holder {
    private Singleton s = Singleton.SINGLE;
    
    public Singleton get() {
        return s;
    }
}
