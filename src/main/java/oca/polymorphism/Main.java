package oca.polymorphism;

public class Main {
    public static void main(String[] args) {
        Animal[] zoo = {
                new Lion(), new Dog()
        };

        ZooKeeper zooKeeper = new ZooKeeper();
        zooKeeper.feedAnimals(zoo);
    }
}
