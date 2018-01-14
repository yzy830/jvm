package com.gerald.jvm.chapter10.generic;

import java.util.List;
import java.util.stream.Collectors;

public class StringGenericInfo extends GenericInfo<String, Integer> {
    private List<Long> list;
    
    public List<String> map(List<? extends Number> numbers) {
        genericLocal("123");
        
        list.add(2L);
        
        return numbers.stream().map(Number::toString).collect(Collectors.toList());
    }
    
    public <U> void genericLocal(U arg) {
        U local = arg;
        
        System.out.println(local);
    }
}
