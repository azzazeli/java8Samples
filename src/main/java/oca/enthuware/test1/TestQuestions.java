package oca.enthuware.test1;

/**
 * @author AlexM
 **/
public class TestQuestions {
    String s  = this.toString();

    public static void main(String[] args) {
        question68();
        question67();
        question66();
        question58();
        question31();
        question30();
        question24();
        question6();
        question5();
        question2();
    }

    private static void question68() {
        boolean b = true | false;
        boolean b1 = true || false;
    }

    private static void question67() {
        System.out.println("===========q67=============");
        Integer i = new Integer(1);
        Long m = new Long(1);

        if(i.equals(m)) System.out.println("equals");
        else System.out.println("not equals");

    }

    private static void question66() {
        System.out.println("========================");
        int x = 1;
        int y = 0;
//        if( x/y ) System.out.println("Good"); //Boolean expression is expected
//        else System.out.println("Bad");
    }

    private static void question58() {
        System.out.println("========================");
        String [] sA = new String[] {"a"};
//        String [] sA1 = new String[1] {"a"}; //DOES NOT COMPILE
    }

    private static void question31() {
        System.out.println("========================");
        boolean b1 = false;
        boolean b2 = false;

//        if(b1 != b2 = !b2){  } //DOES NOT COMPILE

    }

    private static void question30() {
        System.out.println("========================");
        int index = 1;
        try{
            getArray()[index = 2]++;
        }
        catch (Exception e) {}
        System.out.println("index=" + index);
    }

    public static int[] getArray(){
//        throw new NullPointerException();
        return null;
    }

    private static void question24() {
        System.out.println("========================");
        String str1 = "one";
        String str2 = "two";
        System.out.println(str1.equals(str1=str2));
//        System.out.println(Math.round(0.49));
    }

    private static void question6() {
        System.out.println("========================");
        boolean b;
        if(b = true){
            System.out.println("TRUE");
        }
    }

    private static void question5() {
        Long var = new Long("123");
//        new Long();// NO CONSTRUCTOR
    }

    private static void question2() {
        char c;
        int i;
        final int ii =0;
        c ='a';
        i = c;
        i++;
        c = ii;
//        c = i; //WILL NOT COMPILE
    }
}
