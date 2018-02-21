package oca.enthuware.foundation;

public class IntegerMinValue {
    public static void main(String[] args) {
        int a = Integer.MIN_VALUE;
        int b = -a;
        System.out.println( a+ "   "+b);
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
    }
}
