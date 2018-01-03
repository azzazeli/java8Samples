package oca.hiding.staticmethods;

public class Panda extends Bear {
    public static void eat() {
        System.out.println("Panda bear is chewing");
    }
/*
    //DOS NOT COMPILE
    public void sneeze(){ //DOS NOT COMPILE
        System.out.println("Panda bear sneezes quietly");
    }
*/

/*
    //DOS NOT COMPILE
    public static void hibernate(){
        System.out.println("Panda bear is going to sleep");
    }
*/

    public static void main(String[] args) {
        Panda.eat();
    }
}
