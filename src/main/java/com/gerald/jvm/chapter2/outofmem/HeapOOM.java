package com.gerald.jvm.chapter2.outofmem;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {
    private static class OOMObject {
        private byte[] array = new byte[1024 * 1024];
    }
    
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        
        int index = 0;
        while(true) {
            System.out.println(++index);
            list.add(new OOMObject());
        }
    }
}
