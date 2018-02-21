package oca.enthuware.foundation;

public class StringBuilderQuestion {
    public static void main(String[] args) {
        question1();
    }

    private static void question1() {
        StringBuilder b1 = new StringBuilder("snorkler");
        StringBuilder b2 = new StringBuilder("yoodler");
        testQuestion1(new StringBuilder(b1), new StringBuilder(b2));
        testQuestion2(new StringBuilder(b1), new StringBuilder(b2));
        testQuestion3(new StringBuilder(b1), new StringBuilder(b2));
    }

    private static void testQuestion3(StringBuilder b1, StringBuilder b2) {
        b1.replace(3, 4, b2.substring(4)).append(b2.append(false));
        System.out.print(b1 + "|"); System.out.println(b2);
    }

    private static void testQuestion2(StringBuilder b1, StringBuilder b2) {
        b2.insert(3, b1.append("a"));
        System.out.print(b1 + "|"); System.out.println(b2);
    }

    private static void testQuestion1(StringBuilder b1, StringBuilder b2){
        b1.append( b2.substring(2,5).toUpperCase() );
        System.out.print(b1 + "|"); System.out.println(b2);

    }

}
