package com.samples.java8.classwins;

public interface Named {
    default String getName(){
        return getClass().getName() + "_" + hashCode();
    }
}
