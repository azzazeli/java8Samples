package oca.enthuware.test1;

/**
 * @author AlexM
 **/

class A {}
class AA extends A {}

public class Q40 {
    public static void main(String[] args) {
        A a = new A();
        AA aa = new AA();
        a = aa;
        System.out.println(" a=" + a.getClass());
        System.out.println("aa=" + aa.getClass());
    }
}
