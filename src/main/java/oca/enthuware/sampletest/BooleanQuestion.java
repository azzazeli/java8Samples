package oca.enthuware.sampletest;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class BooleanQuestion {
    public static void main(String[] args) {
        System.out.println(Boolean.parseBoolean("true"));
        System.out.println(new Boolean("true"));
        System.out.println(new Boolean(null));
//        System.out.println(new Boolean());//DOES NOT COMPILE
        System.out.println(new Boolean("trUE"));
//        Boolean .valueOf(truw); //DOES NOT COMPILE
        Boolean .valueOf(true);

        System.out.println("===========================");
        System.out.println(new Boolean(true) == new Boolean(true));
        System.out.println("===========================");
        System.out.println(new Boolean(true) == Boolean.parseBoolean("True"));
    }
}
