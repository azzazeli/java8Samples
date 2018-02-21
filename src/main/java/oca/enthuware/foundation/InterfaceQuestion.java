package oca.enthuware.foundation;

public class InterfaceQuestion {

    interface I {
        void m1();
    }

    abstract class Klass {
        abstract void m1();
    }

    class SubClass extends Klass implements I {
        public void m1(){}
        //subclasses are allowed to increase method visibility
    }

}
