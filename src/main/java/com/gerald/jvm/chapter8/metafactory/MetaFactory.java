package com.gerald.jvm.chapter8.metafactory;

import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.function.Predicate;

/**
 * 本案例使用LambdaMetafactory模拟了JAVA SE8对lambda表达式的处理
 *
 */
public class MetaFactory {
    public static void main(String[] args) throws Throwable {
        String invokedName = "test";
        MethodType invokedMT = MethodType.methodType(Predicate.class, int.class);
        MethodType samMT = MethodType.methodType(boolean.class, Object.class);
        MethodType instantiatedMT = MethodType.methodType(boolean.class, String.class);
        
        MethodHandle mh = MethodHandles.lookup()
                                       .findStatic(MethodHandles.lookup().lookupClass(),
                                                   "t", 
                                                   MethodType.methodType(boolean.class, 
                                                                         int.class, 
                                                                         String.class));
        //模拟invokedynamic，获得一个CallSite。CallSite的签名具有invokedMT形式，
        //以便接收捕获变量
        CallSite callSite = LambdaMetafactory.metafactory(MethodHandles.lookup(), 
                                                          invokedName, 
                                                          invokedMT, 
                                                          samMT, 
                                                          mh, 
                                                          instantiatedMT);
        
        
        Predicate<String> p = (Predicate<String>)callSite.getTarget().invoke(2);
        
        System.out.println(p.test("123"));
    }
    
    //lambda表达式实现
    private static boolean t(int a, String b) {
        System.out.println(a);
        
        return  b != null;
    }
}
