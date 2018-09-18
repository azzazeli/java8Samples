package oca.enthuware.test2;

/**
 * @author AlexM
 **/
public class Q58 {
    public static void main(String[] args) {
        int i =0;
        loop:
        {
            System.out.println("Loop lable line");
            try {
                for (; true; i++) {
                    if (i > 5) break loop;
                }
            }
            catch (Exception e){
                System.out.println("Exception in loop");
            }
            finally {
                System.out.println("In Finally");
            }
        }
    }
}
