package com.gerald.jvm.chapter6.bytecode;

public class BranchControl {
    public void intBranch() {
        int a = 1;
        
        if(a > 1) {
            System.out.println(">1");
        } else {
            System.out.println("<=1");
        }
    }
    
    public void boolBranch() {
        boolean a = true;
        
        if(a) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
