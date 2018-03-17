package oca.enthuware.test1;

/**
 * @author AlexM
 **/
public class Q59 {
    public static void main(String[] args) {
        switch (Integer.parseInt(args[0])){
            case 0:
                boolean b = false;
                for (String arg : args) {
                    System.out.println();
                }
                System.out.println();
                break;
            case 1:
                b = true;
                break;
        }

//        if(b) System.out.println(args[2]); CANT RESOLVE b
    }
}
