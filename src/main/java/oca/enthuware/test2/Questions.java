package oca.enthuware.test2;


import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Questions {
    public static void main(String[] args) {
//        DateTimeFormatter.ISO_DATE
        question7();
//        question8();
//        question14();
//        question19();
//        question26();
//        question27();
//        question28();
//        question29();
//        question33();
//        question32();
//        question35();
//        question40();
        question50();
//        question64();
//        question66();
    }

    private static void question50() {
        int j = 10;
        POINT1: for(int i =0; i< 10; i++) {
            boolean flag = false;
            while (!flag) {
                if (Math.random() > 0.5) break POINT1;
            }
        }

        while (j<10) {
            System.out.println(j--);
//            if (j==4) break POINT1; //WILL NOT COMPILE
        }
    }

    private static void question7() {
        int i = 2*10/6;
        System.out.println(i);
    }

    private static void question66() {
        int [] values = {10,20,30};
        for (int k: values) {}
//        for (int k; k<10; k++) {} //DOES NOT COMPILE k should be initialized
        for(;;);
//        for(; k<values.length; k++) {} //DOES  NOT COMPILE ; must be declared first
    }

    private static void question64() {
//        float f1 = 1.0; //DOES NOT COMPILE
//        float f2 = 43e1; //DOES NOT COMPILE
        float f3 = -1;
        float f4 = 0x1234;
        float f = 4;
    }

    private static void question33() {
        short s = 12;
        long g = 012;
        float f = - 123;
//        float d =  0*1.5; //DOES NOT COMPILE
    }

    private static void question27() {
        int s = 5;
        s+= s + mx(s) + ++s;
        System.out.println(s);
    }

    private static int mx(int s){
        for (int i = 0; i < 3; i++) {
            s = s + i;
        }
        return s;
    }

    private static void question40() {
        System.out.println("======q40======");
        Integer i =new Integer(42);
        Long ln = new Long(42);
        Double db = new Double(42.0);

//        i == ln;//operator '==' cannot be applied  Integer, Long
//        ln ==db; //opertator '==' cannot be applied to Long and Double
        i.equals(db);
        db.equals(ln);
        ln.equals(42);
    }

    private static void question35() {
        System.out.println("======q35======");
        int x = 10;
        do {
            --x;
        }while (x< 10);
        System.out.println(x);
    }

    private static void question32() {
        System.out.println("======q32======");
        String str = "01234567";
//        str.substring(4,3);
        //throws StringIndexOutOfBoundsException
        "emptiness".substring(9);
    }

    private static void question29() {
        System.out.println("======q29======");
        Object obj  = null;
        Collection<String> c = new ArrayList<>();
        int[][] ia = new int[2][2];

//        for(o : c){} //CANNOT USE EXISTING VAR IN DECLARATION PART

        for(final Object o2: c) {} //ONLY final modifier is allowed in this part of FOR

//        for(Iterator it : c) {} c.iterator() does not return any Collection
    }

    private static void question28() {
        System.out.println("======q28======");
        System.out.println(Boolean.parseBoolean("true") == true);
        System.out.println(Boolean.parseBoolean("trUe") == new Boolean(null));
        System.out.println(new Boolean("TruE") == new Boolean(true));
        System.out.println(new Boolean("TruE") == Boolean.TRUE);
        System.out.println(new Boolean("no") == false);
        System.out.println(Boolean.valueOf("true") == Boolean.valueOf("True"));
        System.out.println(new Boolean("true") == new Boolean("true"));
        System.out.println(new Boolean("true") == Boolean.parseBoolean("true"));
//        new Boolean() //there is no no-arg constructor
    }

    private static void question26() {
        System.out.println("======q26======");
        String str = "ee";
        switch (str){
            case "a":
                System.out.println("ura");
            default:
                System.out.println("test");
        }
    }

    private static void question19() {
        int c = 0;
        JACK: while (c<8){
            JILL:
            System.out.println(c);
//            if(c>3) break JILL; else c++; //UNDEFINED LABEL JILL
            //JILL scope extends only up till System.out.println
        }
    }

    private static void question14() {
        int x = 0;
//        while (false) { x = 3;} //DOES NOT COMPILE
        //unreachable statement
        if(false){ x = 3; }
    }

    private static void question8() {
        System.out.println("======q8======");
        int i = 0;
        int[] ia = {10,20};
        ia[i] = i = 30;

        System.out.println(ia[0] + " " + ia[1] + " " + i);
    }
}
