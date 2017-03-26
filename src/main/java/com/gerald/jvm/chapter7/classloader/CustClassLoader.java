package com.gerald.jvm.chapter7.classloader;

import java.io.IOException;
import java.io.InputStream;

public class CustClassLoader extends ClassLoader {
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
        InputStream is = getClass().getResourceAsStream(fileName);
        if(is == null) {
            return super.loadClass(name);
        }
        
        try {
            byte[] b = new byte[is.available()];
            is.read(b);
            return defineClass(name, b, 0, b.length);
        } catch (IOException e) {
            throw new ClassNotFoundException(name, e);
        }
    }
}
