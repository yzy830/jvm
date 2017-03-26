package com.gerald.jvm.chapter8;

import java.util.function.Predicate;

/**
 * 本案例使用lambda表达式展示了java生成的invokedynamic指令以及Bootstrap属性
 *
 */
public class DynamicInvoke { 
    
    private void testLambda() {
        int a = 2;
        Predicate<String> p = t-> {
            System.out.println(a);
            return t!=null;
        };
        
        System.out.println(p.test(null));
    }
    
    public static void main(String[] args) {
        DynamicInvoke d = new DynamicInvoke();
        d.testLambda();
    }
    
    public static class LambdaImpl implements Predicate<String> {
        private final int arg0;
        
        private LambdaImpl(int arg0) {
            this.arg0 = arg0;

        }

        @Override
        public boolean test(String t) {
            return DynamicInvoke.lambda(arg0, t);
        }
    }
    
    private static boolean lambda(int a, String t) {
        System.out.println(a);
        return t!=null;
    }
}
