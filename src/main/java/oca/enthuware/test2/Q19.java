package oca.enthuware.test2;

public class Q19 {
    public static void main(String[] args) {
        crazyLoop();
    }

    static void crazyLoop() {
        int c = 0;
        JACK: while (c < 8) {
            // scop of JILL extends only up to System.out.println()
            JILL:
            {
                System.out.println(c);
                if (c < 3) break JILL;
                else c++;
            }
         }
    }
}
