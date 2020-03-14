package com.alexm.cleancode.args;

/**
 * @author AlexM
 * Date: 3/12/20
 **/
public class Main {
    public static void main(String[] args) {
        try {
            Args arg = new Args("l, p#,d*", args);
            boolean logging = arg.getBoolean('l');
            int port = arg.getInt('p');
            String directory = arg.getString('d');
            executeApplication(logging, port, directory);
        } catch (ArgsException e) {
            System.out.printf("Argument error: %s\n", e.getErrorMessage()); //NOSONAR
        }
    }

    private static void executeApplication(boolean logging, int port, String directory) {
        System.out.println("logging:" + logging); //NOSONAR
        System.out.println("port:" + port); //NOSONAR
        System.out.printf("directory:" + directory); //NOSONAR
    }
}
