package oca.inheritance;

public class Main {
    public static void main(String[] args) {
        Person p = new Person("Andrew", "Gray");
        System.out.printf("%s has %s hair\n", p.getName(), p.hairColor);
        p.greet();
        System.out.println("=======================================");
        Friend f = new Friend("Tony", "Blond", "help you fix that flat tire");
        System.out.printf("%s has %s hair\n", f.getName(), f.hairColor);
        f.greet();
        f.doFavor();
    }
}
