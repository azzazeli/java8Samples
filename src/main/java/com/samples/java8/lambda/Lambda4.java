package com.samples.java8.lambda;

import com.samples.java8.winterbe.Converter;

public class Lambda4 {
    static int outerStaticNum;
    int outerNum;


    void testScopes(){
        Converter<Integer, String> stringConverter = (from) -> {
            outerNum = 23;
            return String.valueOf(from);
        };

        Converter<Integer, String> stringConverter2 = (from) -> {
            outerStaticNum= 24;
            return String.valueOf(from);
        };

        stringConverter.convert(1);
        stringConverter2.convert(1);
    }
}
