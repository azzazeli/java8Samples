package oca.enthuware.test1;

/**
 * @author AlexM
 **/
class Super {}
class Sub extends Super {}

public class Q38 {
    public static void main(String[] args) {
        Super s1 = new Super();
        Super s2 = new Sub();

        s1 = s2;
    }
}
