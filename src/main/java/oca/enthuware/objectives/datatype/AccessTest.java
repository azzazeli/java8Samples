package oca.enthuware.objectives.datatype;

/**
 * @author AlexM
 **/
public class AccessTest {
    String a = "x";
    static  char b = 'x';
    String c = "x";

    class Inner{
        String a = "y";
        String get(){
            String c = "temp";
            c ="" + AccessTest.b;
            c = "" + b;
            c = AccessTest.this.a;
            return c;
        }
    }

    public AccessTest() {
        System.out.println(new Inner().get());
    }

    public static void main(String[] args) {
        new AccessTest();
    }
}
