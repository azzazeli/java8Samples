package oca.animals;

public class Tiger extends Animal {
    public Tiger() {
        super(4);
        System.out.println("Initializer for Tiger");
    }

    @Override
    public String likesToEat() {
        return "Meat";
    }
}
