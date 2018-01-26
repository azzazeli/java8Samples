package oca;

public class TestPrivate {
    private int test = 2;
    private TestPrivate(){}

    public static void main(String[] args) {
        TestPrivate testPrivate = new TestPrivate();
    }
}
