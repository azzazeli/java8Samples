package oca.ch1;


import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Finalizer {
    int Finalizer(){
        return 0;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Calling finalize");
    }

    private void testDivide(){
        short x = 10;
        short y = 3;
        System.out.println(x/y);

    }

    private void testCompoundAssignmentOperator(){
        long x = 10;
        int y = 3;
        y *= x;
        System.out.println(y);
    }

    public static void main(String[] args){
        Finalizer finalizer = new Finalizer();
        finalizer.testDivide();
        finalizer.testCompoundAssignmentOperator();


        byte b1 = 22;
        byte b2 = 23;
        byte b3 = (byte)(b1 + b2);
        float  f1 = 1*2F;
        long longVal = 1;

        int[] array = {1, 2};
        System.out.println(Arrays.toString(array));
        finalizer.testArray(array);
        System.out.println(Arrays.toString(array));

        System.out.println("-------------------");
        System.out.printf("10%%3=%d\n", 10%3);
        System.out.printf("3%%10=%d\n", 3%10);
        System.out.printf("-10%%3=%d\n", -10%3);
        System.out.printf("-10%%-3=%d\n", -10%-3);
        System.out.printf("10%%20=%d\n", 10%20);
        System.out.printf("-10%%20=%d\n", -10%20);
        System.out.printf("-10.5%%-3.1=%.2f\n", -10.5%3.1);


        System.out.println("-------------------");
        System.out.println((byte)(100 + 28));
        System.out.println("sadas " +2 + 1);
        System.out.println(2 + 1 +"sadas ");

        System.out.println("-------------------");
        byte t= 10, s;
        s = ++t;

        s+=t;
//        s = s +t ;
        System.out.println("-------------------");
        double d = 9_000_000_000_000_000_000D;
        System.out.println("d:"+d);
        d+=500;
        System.out.println("d:"+d);


        byte b = (byte)(123 - 100);
        String s22= "hello";
        int i = 10;

        switch (s22){
            case "a": {
                System.out.println("aa");
                System.out.println("aa");
                System.out.println("aa");
                break;
            }
            case "b":
                System.out.println(222);
                System.out.println(222);
                System.out.println(222);
                break;
        }

        System.out.println("-------------------");
        int x1 = 50, x2 = 75;
        boolean b33 = x1 >= x2;

        finalizer.test1();
        finalizer.testArray2();
        finalizer.testLoop();
        finalizer.test(Float.valueOf(1f));

    }

    private void test1(){
        long x=10;
        int y = 2*(int)x;
//        for (int i = 0; i < 10; ) {
//            i = i++;
//            System.out.println("Hello World");
//        }

        int size = 10;
        int[] arr = new int[size>0?12:2];
        for (int t: arr) {
            System.out.println(t);

        }

        int[] newarray = {1,};
        for (int t: newarray) {
            System.out.println("sssss");
        }
    }

    private void testArray(int[] array){
//        array = null;
        array[0]=99;
        System.out.println(Arrays.toString(array));

    }

    private void testArray2(){
        int[] a1 = {1,2,3};
        int[] a2 = new int[10];
        System.arraycopy(a1, 0,a2,0, a1.length );
        for(int i: a2){
            System.out.println("!!!"+i);
        }


        int[][] aii = {
            {1},
            {1, 2},
            {1,2,3},
        };

        int  aaaa [] = new int[1];

    }

    public void testLoop(){
        System.out.println("-----------------------------------");
        ls:for (int i = 0; i <5; i++) {
            l:for (int j = 0; j < 2; j++) {
                System.out.println("i:" + i + " j:" + j);
                if(i==2){
                    break ls;
                }

            }
        }
        int _$iid;
    }

    private void testString(){
        //String test = 5+1;
        String s="test1";
        StringBuilder s2 = new StringBuilder("test1");
//        if(s==s2)
        Period p = Period.ofDays(1);

    }

    private void testStream(){
//        final List<Double> B = list.stream()
//                .map(CoreResult::getField)
//                .flatMap(Collection::stream)
//                .collect(Collectors.toList());
    }

    native private void  n();


    public void test(float a){
        System.out.println("float");

    }

    public void test(Float a){
        System.out.println("Float");
    }

    public int test(int a){
        int x = 22 / 2;
        return 0;
    }

    private void argList(String s, int i){

    }

    private void argList(int i, String s){

    }

    private void argList(int... i){

    }

}
