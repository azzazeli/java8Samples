package oca.inheritance;

public class Friend extends Person {
    private String favor;

    public Friend(String name, String hairColor, String favor) {
        super(name, hairColor);
        this.favor = favor;
    }

    public void doFavor() {
        System.out.printf("Hey, my friend, let me %s !", favor);
    }

    @Override
    public void greet(){
        System.out.printf("Hello, my friend, it is:%s\n", getName());
    }
}
