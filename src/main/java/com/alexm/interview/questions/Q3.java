package com.alexm.interview.questions;

/**
 * @author AlexM
 * Date: 3/22/20
 **/
public class Q3 {

    public synchronized void m1 () {
        System.out.println("m1");
    }

    public synchronized void m2 () throws InterruptedException {
        Thread.sleep(5);
        System.out.println("m2");
    }

    public static synchronized void m3 () throws InterruptedException {
        Thread.sleep(20);
        System.out.println("m3");
    }

    public static synchronized void m4 () {
        System.out.println("m4");
    }

    public void m5() throws InterruptedException {
        synchronized (this) {
            Thread.sleep(10);
            System.out.println("m5");
        }
    }

    public void m6() {
        synchronized (Q3.class) {
            System.out.println("m6");
        }
    }


    public static void main(String[] args) {
        Q3 q3 = new Q3();
        for (int i=0; i< 5; i++) {
            new Thread(() -> {
                try {
                    q3.m1();
                    q3.m2();
                    q3.m3();
                    q3.m4();
                    q3.m5();
                    q3.m6();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
