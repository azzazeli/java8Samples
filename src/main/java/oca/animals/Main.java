package oca.animals;

public class Main {
    public static void main(String[] args) {
//        Animal animal = new Animal(4);
        Animal animal = new Tiger();
        System.out.printf("Animal %s has %s legs and likes to eat  %s %n",
                animal.getClass().getName(), animal.getLegs(), animal.likesToEat());
    }
}
