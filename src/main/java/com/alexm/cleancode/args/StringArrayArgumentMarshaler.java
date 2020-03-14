package com.alexm.cleancode.args;

import java.util.Iterator;

/**
 * @author AlexM
 * Date: 3/12/20
 **/
public class StringArrayArgumentMarshaler implements ArgumentMarshaler {
    public static String[] getValue(ArgumentMarshaler argumentMarshaler) {
        return new String[0];
    }

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {

    }
}
