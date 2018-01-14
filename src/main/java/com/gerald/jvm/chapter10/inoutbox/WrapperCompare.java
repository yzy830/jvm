package com.gerald.jvm.chapter10.inoutbox;

public class WrapperCompare {
    /**
     * 演示包装类型的比较
     */
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        
        /*
         * true。引用类型比较。编译器使用Integer.valueOf装箱，而Integer.valueOf
         * 默认缓存-128~127的值。因此，c==d返回true
         * */
        System.out.println(c == d);          
        /*
         * false。原因如上
         * */
        System.out.println(e == f);
        /*
         * true。当遇到算数运算时，编译器会执行拆箱。因此下面两行代码都返回true。
         * 对应的代码相当于
         * c.intValue() == (a.intValue() + b.intValue())
         * e.intValue() == (f.intValue() + 0);
         * */
        System.out.println(c == (a + b));
        System.out.println(e == (f + 0));
        /*
         * true。包装类型的equals会显式执行拆箱操作
         * */
        System.out.println(e.equals(f));
        /*
         * true。因为执行了拆箱操作
         * */        
        System.out.println(g == (a + b));
        /*
         * false。包装类型的equals方法会首先判断类型是否兼容。
         * 在下面的操作中，a + b会首先执行拆箱操作得到一个int
         * 结果，然后为了转换为一个Object类型，装箱为Integer
         * 类型，最后相当于执行了
         * Long#equals(Integer)，由于Long与Integer类型不兼容，
         * 因此返回false
         * */
        System.out.println(g.equals(a + b));
        
    }
}
