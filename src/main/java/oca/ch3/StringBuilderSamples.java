package oca.ch3;

public class StringBuilderSamples {
    public static void main(String[] args) {
        StringBuilderSamples samples = new StringBuilderSamples();
        samples.testChaining();
    }

    private void testChaining(){
        StringBuilder a = new StringBuilder("abc");
        StringBuilder b = a.append("de");
        b = b.append("f").append("g");
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }
}
