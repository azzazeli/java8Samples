package oca.polymorphism;

public class Lion extends Animal {
    private static final String FAVORITE_FOOD = "Meat";

    @Override
    public String getName(){
        return "Larry the Lion";
    }

    @Override
    public String eats(){
        return FAVORITE_FOOD;
    }

    @Override
    public void eat(String food){
        if (food.equals(FAVORITE_FOOD)){
            System.out.printf("Roar, yum , I love %s.\n", food);
        }
        else {
            System.out.println("ROAR! .... Eat the zookeeper!");
        }
    }
}
