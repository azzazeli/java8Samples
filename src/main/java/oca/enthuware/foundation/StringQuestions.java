package oca.enthuware.foundation;

public class StringQuestions {
    public static void main(String[] args) {
        question1();
    }

    private static void question1() {
        String s = "test";
        s.length();
        s.hashCode();
        s.trim();
        s.concat("1");
//        s.reverse();//StringBuilder has this method
    }
}
