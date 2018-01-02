package oca.casting;

public class Main {
    public static void main(String[] args) {
        Animal theAnimal = new Animal();

        Pet pet = (Pet) theAnimal;
        Animal otherAnimal = (Animal)pet;
        Tiger tiger = (Tiger) pet;

    }
}
