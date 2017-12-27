package com.samples.java8.winterbe;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class FormulaTest {
    List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

    @Test
    public void calculate() throws Exception {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(100 * a);
            }
        };


        System.out.println(formula.calculate(100));
        System.out.println(formula.sqrt(100));
    }

    @Test
    public void lambda(){
        Collections.sort(names, (a,b) -> b.compareTo(a));
        System.out.println(names);
    }


}