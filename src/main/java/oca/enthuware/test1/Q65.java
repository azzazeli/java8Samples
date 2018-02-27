package oca.enthuware.test1;

/**
 * @author AlexM
 **/
public class Q65 {
    public static void main(String[] args) throws Exception {
        Q65 instance = new Q65();
        instance.myMethod();
    }

    public void myMethod() throws Exception {
        yourMethod();
    }

    public void yourMethod() throws Exception {
        throw new Exception();
    }
}
