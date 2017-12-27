package oca.accessmodifiers.pond.duck;

public class GoodDuckling {
    public void makeNoise(){
        MotherDuck duck = new MotherDuck();
        duck.quack();
        System.out.printf(duck.noise);
    }
}
