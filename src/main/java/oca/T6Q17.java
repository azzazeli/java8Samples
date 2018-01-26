package oca;

public class T6Q17 {
    class HasSoreThroatException extends Exception {}
    class TiredException extends RuntimeException {}

    interface Roar {
        void roar() throws HasSoreThroatException;
    }
    class Lion implements Roar {// INSERT CODE HERE

        @Override
        public void roar() {

        }
    }


}
