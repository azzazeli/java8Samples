package com.alexm.interview.questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author AlexM
 * Date: 3/22/20
 **/
public class Q2 {

    private void m1(String val) {
        val += "defg";
    }

    private void m2(int i) {
        i+=10;
    }

    private void m3(StringBuilder sb) {
        sb.append("234");
    }

    private void m4(int[] ar) {
        ar[1] = 7;
    }

    private void m5(List<Integer> list) {
        list.add(333);
    }

    private void m6(AtomicInteger ai) {
        ai.incrementAndGet();
    }


    public static void main(String[] args) {
        Q2 q2 = new Q2();
        String s1 = "abc";
        q2.m1(s1);

        int i1 = 20;
        q2.m2(i1);

        int[] ai = new int[4];
        q2.m4(ai);

        StringBuilder sb = new StringBuilder("ops");
        q2.m3(sb);

        List<Integer> list = new LinkedList<>(Arrays.asList(22,44, 55));
        q2.m5(list);

        AtomicInteger ati = new AtomicInteger(65);
        q2.m6(ati);

        System.out.println(s1);
        System.out.println(i1);
        System.out.println(Arrays.toString(ai));
        System.out.println(sb.toString());
        System.out.println(list);
        System.out.println(ati);
    }

}
