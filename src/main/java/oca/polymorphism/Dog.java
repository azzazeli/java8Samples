package oca.polymorphism;

public class Dog extends Animal {
    @Override
    public String getName() {
        return "Dougal the Dog";
    }

    @Override
    public String eats() {
        return "Kibbles";
    }

    @Override
    public void eat(String food) {
        System.out.printf("Woof, wag! Great %s ! I eat everything anyway, so I like this too\n", food);
    }
}
