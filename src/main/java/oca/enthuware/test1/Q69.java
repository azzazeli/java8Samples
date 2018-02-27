package oca.enthuware.test1;

/**
 * @author AlexM
 **/


interface I1 {
    static void valid(){}
    default void invalid(){}
}

interface I2 extends I1 {
    default void valid(){}
//    static void invalid(){} //static method cannot override instance method
}


public class Q69 {

}
