package oca.polymorphism;

public class Animal {

    public String getName(){
        return "Unknown";
    }

    public String eats(){
        return "Unknown";
    }

    public void eat(String food){
        System.out.println("Hmm, food, I'm an idea, so I don't really eat much!");
    }
}
