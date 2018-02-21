package oca.enthuware.foundation;

public class DataTypeQuestions {
    public static void main(String[] args) throws Exception{
        question1();
        System.out.println("=========================");
        testConversion();
        conversion2();
        conversion3();
    }

    private static void conversion3() {
        short s = Short.MAX_VALUE;
//        char c = s; //WILL NOT COMPILE even if it fits; will compile if s is final


        final short s1 = Short.MAX_VALUE;
        char c1 = s1;

        final short short_var = 200;
//        byte byte_var = short_var; //WIL NOT COMPILE; value is too big

    }

    private static void conversion2() {
        char c = 'a';
        long long_var = c;

        byte byte_var = 120;
        short short_var = byte_var;

//        c = short_var;
        int int_var =100;
        float f = int_var;


        final int k = 10;
        byte_var = k;

    }

    private static void question1() {
        int a = 5, b = 7, k = 0;
        Integer m = null;
        k = new Integer(a) + new Integer(b);    System.out.println(k);
        k = new Integer(a) + b;                 System.out.println(k);
        k = b + new Integer(a);                 System.out.println(k);
        m = new Integer(a) + new Integer(b);    System.out.println(m);

    }

    public static void testConversion(){
        int i = 1234567890;
        float f = i;
        System.out.println(i - (int)f);
        System.out.println(i - f);
    }

//    static {
//        throw new NullPointerException();
//    }

    //Initializer must be able to complete normally
}
