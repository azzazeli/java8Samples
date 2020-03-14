package com.alexm.cleancode.args2;

/**
 * @author AlexM
 * Date: 3/14/20
 **/
public class Main {
    public static void main(String[] args) {
        try {
            Args arg = new Args("l,p#, d*", args);
            boolean logging  = arg.getBoolean("l");
            int port = arg.getInteger("p");
            String directory = arg.getString("d");
            executeApplication(logging, port, directory);
        } catch (ArgsException e) {
            System.out.printf("Argument error: %s\n", e.errorMessage());
        }
    }

    private static void executeApplication(boolean logging, int port, String directory) {
        System.out.printf("logging: %S\n", logging); //NOSONAR
        System.out.printf("port: %S\n", port); //NOSONAR
        System.out.printf("directory: %S\n", directory); //NOSONAR
    }
}
