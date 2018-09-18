package oca.enthuware.test2;

/**
 * @author AlexM
 **/
public class Q56 {
    public static void main(String[] args) {
        A a = new B();
        a.print();
    }
}

class A {
    A(){
        print();
    }

    void print() {
        System.out.println("A");
    }
}

class B extends A {
    int i = 4;
    void print() {
        System.out.println(i);
    }
}
