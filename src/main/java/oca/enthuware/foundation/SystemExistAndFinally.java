package oca.enthuware.foundation;

public class SystemExistAndFinally {
    public static void main(String[] args) {
        try{
            System.exit(1);
        }
        finally {
            System.out.println("finally is always executed");
        }

        //EXPECTED NO OUTPUT
    }

}
