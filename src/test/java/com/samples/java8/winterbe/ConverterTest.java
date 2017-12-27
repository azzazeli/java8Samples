package com.samples.java8.winterbe;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConverterTest {

    @Test
    public void convert(){
        Converter<String, Integer> converter = from -> Integer.valueOf(from);
        Integer converted =  converter.convert("123");
        System.out.println(converted);

        Converter<String, Integer> converter2 =Integer::valueOf;
        System.out.println(converter2.convert("145"));

    }

    @Test
    public void something(){
        Converter<String, String> converter = Something::startWith;
        System.out.println(converter.convert("Java"));
    }

}