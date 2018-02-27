package oca.enthuware.test1;

/**
 * @author AlexM
 **/

interface T1 {}
interface T2 {
    int VALUE = 10;
    void m1();
}

interface T3 extends T1, T2 {
    public void m1();
    public void m1(int x);
}

public class Q51 {

}
