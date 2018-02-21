package oca.enthuware.foundation.methodsquestion.b;

import oca.enthuware.foundation.methodsquestion.a.AccessTest;

public class AccessTester extends AccessTest{

    private void test(){
        c();
    }

    public static void main(String[] args) {
        AccessTest ref = new AccessTest();
        ref.d();
//        ref.c(); NO ACCESS

        AccessTester tester = new AccessTester();
        tester.c();

        SubAccessTester subAccessTester = new SubAccessTester();
        subAccessTester.c();
    }
}
