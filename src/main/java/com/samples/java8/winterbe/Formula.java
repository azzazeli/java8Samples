package com.samples.java8.winterbe;

public interface Formula {
    double calculate(int a);

    default double sqrt(int a){
        return Math.sqrt(a);
    }
}
