package oca.tryresources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        brokenTwo();
    }

    public static void brokenTwo() {
        System.out.println("Starting");
        try (MyResource r = new MyResource();){
            System.out.println("In try");
        } catch (IOException e) {
            System.out.println("Close failure?");
        }
        finally {
            System.out.println("Explicit finally");
        }

        List<String> list =  new ArrayList<>(); //diamond operator
    }
}
