package oca.test4;

public class T4Q5 {
    public static void main(String[] args) {
        T4Q5 instance = new T4Q5();
//        instance.howMany(true, {true, true}); //DOES NOT compile
    }

    public int howMany(boolean b, boolean ... b2){
        return b2.length;
    }
}
