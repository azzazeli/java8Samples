package oca.enthuware.foundation;

public class SwitchQuestion {
    public static void main(String[] args) {

        question1();
        question2();
    }

    private static void question2() {
        char ch = 'x';
        switch (ch){
//            case -1: //INCOMPATIBLES TYPES
//                System.out.println("");
        }
    }

    private static void question1() {
        Integer x = 1;
        int y = 1;
        char a = 'a';
        int test = a;
//        x = a;//DOES NOT COMPILE incompatible types
        switch (y){
            case 'a':
                System.out.println("test");
        }
    }
}
