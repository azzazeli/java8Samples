package oca.enthuware.objectives.datatype;

/**
 * @author AlexM
 **/
public class Test {
    public static void main(String[] args) {
        chainingDeclaration();
        validTwoUnderscore();
        question5();
        wrongFloatAssignment();
        mathRoundQuestion();
    }

    private static void mathRoundQuestion() {
        System.out.println("===================");
        System.out.println(Math.round(-0.5));
    }

    private static void wrongFloatAssignment() {
//        float f = 0 * 1.5; // INCOMPATIBLE TYPES
    }

    private static void question5() {
        boolean b = false;
        if(b=true) {
            System.out.println("TRUE");
        }
    }

    private static void validTwoUnderscore() {
        int i = 1__4;
    }

    private static void chainingDeclaration() {
        int a, b, c;
        a = b = c = 10;

        int b1 = 0, c1 = 0;
        int a1 = b1 = c1 = 10;
    }
}
