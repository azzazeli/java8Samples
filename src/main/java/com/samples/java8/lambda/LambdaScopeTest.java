package com.samples.java8.lambda;

import java.util.function.Consumer;

public class LambdaScopeTest {
    public int x = 0;

    class FirstLevel {
        public int x = 1;
        void methodInFirstLevel(int x) {
//            x = 99;
            Consumer<Integer> myConsumer = y -> {
                System.out.println("x = " + x); // Statement A
                System.out.println("y = " + y);
                System.out.println("this.x = " + this.x);
                System.out.println("LambdaScopeTest.this.x = " + LambdaScopeTest.this.x);
            };

            myConsumer.accept(x);

        }
    }

    public static void main(String[] args) {
        LambdaScopeTest test  = new LambdaScopeTest();
        FirstLevel fl = test.new FirstLevel();
        fl.methodInFirstLevel(23);
    }
}
