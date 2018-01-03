package oca.virtualmethods;

public class Peacock extends Bird {

    public String getName() {
        return "Peacock";
    }

    public static void main(String[] args) {
        Bird peacock = new Peacock();
        peacock.displayInformation();
    }
}
