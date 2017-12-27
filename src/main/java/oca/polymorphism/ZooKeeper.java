package oca.polymorphism;

public class ZooKeeper {
    public void feedAnimals(Animal [] animals){
        for (Animal animal : animals) {
            String name = animal.getName();
            String food = animal.eats();
            System.out.printf("%s likes %s\n", name, food);
            animal.eat(food);
            System.out.println("=============================");
        }
    }

}
