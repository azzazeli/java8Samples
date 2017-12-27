package com.samples.java8.winterbe;

@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}
