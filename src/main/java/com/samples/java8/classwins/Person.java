package com.samples.java8.classwins;

public interface Person {
    long getId();
    default String getName(){ return "Alex";}
}
