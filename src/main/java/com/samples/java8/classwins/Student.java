package com.samples.java8.classwins;

public class Student implements Named, Person {
    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String getName() {
        return "must be overriden";
    }
}
