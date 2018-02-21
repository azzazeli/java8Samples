package oca.enthuware.foundation;

public class HideFinalVar {
    static class Base {
        final int i = 10;
    }

    static class Sub extends Base {
        final int i = 20;
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        System.out.println(sub.i);

        Base base = new Sub();
        System.out.println(base.i);
    }
}
