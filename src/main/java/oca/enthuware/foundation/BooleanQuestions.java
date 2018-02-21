package oca.enthuware.foundation;

public class BooleanQuestions {

    public static void main(String[] args) {
        tricky1();
    }

    private static void tricky1() {
        System.out.println(new Boolean("true") == new Boolean("true"));
        System.out.println(new Boolean("true") == Boolean.parseBoolean("true"));
        switch ('a'){

        }
    }
}
