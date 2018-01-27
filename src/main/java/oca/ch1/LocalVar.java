package oca.ch1;

public class LocalVar {
    public static void main(String[] args) {
        int y = 10;
        int x;
//        int z = y + x;// DOES NOT COMPILE
        //local variables must be initialized before use
    }

    public void findAnswer(boolean check){
        int answer;
        int onlyOneBranch;
        if(check){
            answer = 1;
            onlyOneBranch = 1;
        }
        else {
            answer =2;
        }
//        System.out.printf(onlyOneBranch);//DOES NOT COMPILE
        //The compiler is smart enough to recognize initialisation that are more complex.
    }

    public void eatIfHungry(boolean hungry){
        if(hungry) {
            int bitesOfCheese = 1;
            {
                boolean teenyBit = true;
                System.out.println(bitesOfCheese);
            }
        }
//        System.out.println(teenyBit);//CANNOT RESOLVE SYMBOL
    }
 }
