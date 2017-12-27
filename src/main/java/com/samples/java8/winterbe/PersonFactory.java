package com.samples.java8.winterbe;

public interface PersonFactory<P extends Person> {
    P create(String first, String last);
}
