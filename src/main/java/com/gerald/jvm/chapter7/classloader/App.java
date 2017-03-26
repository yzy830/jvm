package com.gerald.jvm.chapter7.classloader;

import java.lang.reflect.InvocationTargetException;

public class App {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Holder h1 = new Holder();
        Holder h2 = new Holder();
        
        if(h1.get() == h2.get()) {
            System.out.println("h1 == h2");
        } else {
            System.out.println("h1 != h2");
        }
        
        ClassLoader loader = new CustClassLoader();
        Object h3 = loader.loadClass("com.gerald.jvm.chapter7.classloader.Holder").newInstance();
        
        Object h3Get = h3.getClass().getMethod("get").invoke(h3);
        
        System.out.println("h3 = " + h3Get);
        System.out.println("h1 = " + h1.get());
        
        if(h3Get == h1.get()) {
            System.out.println("h1 == h3");
        } else {
            System.out.println("h1 != h3");
        }
    }
}
