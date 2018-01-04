package oca.m8l5;

public class Main {
    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.showFeatures("Argument value");
        System.out.println("===================");
        sub = new Sub("From main method");
        sub.showFeatures("Argument value");
//        System.out.println("===================");
//        sub.showFeatures("Argument value");
    }
}
