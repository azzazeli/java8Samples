package com.samples.java8.lambda;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    public void operateBinary() throws Exception {
        Calculator.IntegerMath addition = (a, b) -> a + b;
        Calculator.IntegerMath subtraction = (a, b) -> a - b;
        System.out.printf("3+4=%d%n", calculator.operateBinary(3,4,addition));
        System.out.printf("13-4=%d%n", calculator.operateBinary(13,4,subtraction));
    }
}