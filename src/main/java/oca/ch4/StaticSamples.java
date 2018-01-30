package oca.ch4;

public class StaticSamples {
    public static int count = 0;
//    private static final int NUM;

    public static void main(String[] args) {
//        NUM = 1;
        StaticSamples samples = new StaticSamples();
        System.out.println(samples.count);
        samples = null;
        System.out.println(samples.count);
    }
}
