package oca.inheritance;

public class Person {
    private String name;
    public String hairColor;

    public Person(String name, String hairColor) {
        this.name = name;
        this.hairColor = hairColor;
    }

    public String getName() {
        return name;
    }

    public void greet() {
        System.out.printf("Hello, my name is:%s\n", name);
    }

}
