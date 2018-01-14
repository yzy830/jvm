package com.gerald.jvm.chapter10.inoutbox;

import java.util.Arrays;
import java.util.List;

public class InBox {
    /**
     * 这一小段代码包含了自动装箱、自动拆箱、foreach、变长参数、泛型等5个语法糖
     */
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        
        int sum = 0;
        for(int i : list) {
            sum += i;
        }
        
        System.out.println(sum);
    }
}
