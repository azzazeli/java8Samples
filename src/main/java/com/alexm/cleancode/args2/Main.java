package com.alexm.cleancode.args2;

import java.text.ParseException;

/**
 * @author AlexM
 * Date: 3/14/20
 **/
public class Main {
    public static void main(String[] args) throws ParseException, ArgsException {
        Args arg = new Args("l,p#, d*", args);
        boolean logging = arg.getBoolean('l');
        executeApplication(logging);
    }

    private static void executeApplication(boolean logging) {
        System.out.printf("logging: %S\n", logging); //NOSONAR
    }
}
