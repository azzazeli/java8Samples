package oca.hiding.variables;


public class Mouse extends Rodent {
    protected int tailLength = 8;

    public void getMouseDetails(){
        System.out.printf("[tail = %s, parentTail=%s]%n", tailLength, super.tailLength);
    }

    public static void main(String[] args) {
        Mouse mouse = new Mouse();
        mouse.getRodentDetails();
        mouse.getMouseDetails();
    }
}
