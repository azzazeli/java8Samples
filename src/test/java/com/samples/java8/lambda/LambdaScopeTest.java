package com.samples.java8.lambda;

import com.samples.java8.winterbe.Converter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LambdaScopeTest {

    @Test
    public void test1(){
        final int num =1;
        Converter<Integer, String> stringConverter = (from) -> String.valueOf(from + num);
        System.out.println(stringConverter.convert(3));
        assertEquals("4", stringConverter.convert(3));
    }
}
