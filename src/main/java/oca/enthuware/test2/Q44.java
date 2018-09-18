package oca.enthuware.test2;

/**
 * @author AlexM
 **/
public class Q44 {
    int x = 5;
    int getX(){
        return x;
    }
    public static void main(String[] args) {
        Q44 q44 = new Q44();
        q44.looper();
        System.out.println(q44.x);
    }

    //infinite loop
    private void looper() {
        int x = 0;
        while ((x = getX()) != 0) {
            for(int m = 10; m>=0; m--){
                x = m;
            }
        }
    }
}
