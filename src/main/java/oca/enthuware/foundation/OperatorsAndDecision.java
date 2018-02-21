package oca.enthuware.foundation;

public class OperatorsAndDecision {
    public static void main(String[] args)  throws Exception{
//        question1();
        bitwiseNegationSample();
        validIfStatements();
        operatorAnd();
        question2();
    }

    private static void question2() {
        Short k = 9;
        Integer i = 9;
        Boolean b = false;
        char c = 'a';
        String str = "123";

        i = (int)k.shortValue();
        str += b;
        b = !b;
        c += i;
    }

    private static void operatorAnd(){
        System.out.println("================");
        int a = 5&25;
        System.out.println(a);

    }

    private static void validIfStatements() {
        if(true); else ; //legal
        if(true) if(false); //legal and valid
    }


    static void question1(){
        Integer i1 = 1;
        Integer i2  = new Integer(1);
        int i3 = 1;
        Byte b1 = 1;
        Long g1 = 1L;

        System.out.println(i1 == i2);
        System.out.println(i1 == i3);  //one operand is a primitive and other will be unboxed
//        System.out.println(i1 == b1); //WILL NOT COMPILE
        //i1 and b1 references are classes that are not in the same hierarchy
        System.out.println(i1.equals(i2));
        System.out.println(i1.equals(g1)); //objects of different types
        System.out.println(i1.equals(b1)); //objects of different type
        //equals method of wrappers return false if objects are not of the same class
    }

    static void bitwiseNegationSample() {
        System.out.println("=====================");
        Integer unu = Integer.valueOf("1", 2);
        System.out.println(unu);
        Integer minusdoi = ~unu;
        System.out.println(minusdoi);
    }
}
