package oca.m8l5;

public class Base {
    public String x = "Base x value";
    private String y = "Base y value";
    public String z = "Base z value";

    public String getGreetings(){
        return "Hello";
    }

    public Base(){}

    public Base(String x){
        super();
        System.out.println("Back in Base(String)");
        this.x = x;
    }
}
