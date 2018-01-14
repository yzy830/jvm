package com.gerald.jvm.chapter4;

import java.util.concurrent.TimeUnit;


public class App {

    public static void main(String[] args) throws InterruptedException {
        while(true) {
            byte[] a = new byte[256 * 1024];
            a[0] = 1;
            System.out.println(a[0]);
            TimeUnit.MILLISECONDS.sleep(5);
        }
    }

}
