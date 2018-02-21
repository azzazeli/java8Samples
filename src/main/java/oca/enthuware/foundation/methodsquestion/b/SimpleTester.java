package oca.enthuware.foundation.methodsquestion.b;

import oca.enthuware.foundation.methodsquestion.a.AccessTest;

public class SimpleTester {
    public static void main(String[] args) {
        AccessTester test = new AccessTester();
        AccessTest test2 = new AccessTest();
//        test.c(); //DOES NOT COMPILE
//        test2.c();//DOES NOT COMPILE
    }
}
