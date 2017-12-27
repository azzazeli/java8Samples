package com.samples.java8.lambda;

import org.junit.Test;

import static org.junit.Assert.*;

public class Lambda4Test {
    @Test
    public void testScopes() throws Exception {
        Lambda4 lambda4 = new Lambda4();
        lambda4.testScopes();
        assertEquals(23, lambda4.outerNum);
        assertEquals(24, lambda4.outerStaticNum);
    }

}