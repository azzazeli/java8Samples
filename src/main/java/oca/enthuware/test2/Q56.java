package oca.enthuware.test2;

public class Q56 {
    static class A {
        A() { print();}
        void print(){
            System.out.println("A");
        }
    }

    static class B extends A {
        int i = 4;
        @Override
        void print() {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        A a = new B();
        a.print();
    }
}
