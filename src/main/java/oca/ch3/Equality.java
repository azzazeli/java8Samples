package oca.ch3;

public class Equality {
    public static void main(String[] args) {
        Equality e1 = new Equality();
        Equality e2 = new Equality();
        Equality e3 = e1;

        System.out.println(e1 == e1);
        System.out.println(e1 == e2);
        System.out.println(e1 == e3);
    }
}
