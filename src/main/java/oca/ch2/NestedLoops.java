package oca.ch2;

public class NestedLoops {
    public static void main(String[] args) {
        new NestedLoops().testNestedLoop();
    }

    private void testNestedLoop(){
        int x = 20;
        while (x>0){
            do {
               x -=2;
            }while (x>5);
            x--;
            System.out.print(x+" ");
        }
    }
}
