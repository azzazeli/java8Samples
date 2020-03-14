package com.alexm.cleancode.args;

import java.util.Iterator;

/**
 * @author AlexM
 * Date: 3/12/20
 **/
public class BooleanArgumentMarshaler implements ArgumentMarshaler {
    private boolean booleanValue = false;

    public static boolean getValue(ArgumentMarshaler argumentMarshaler) {
        if(argumentMarshaler instanceof BooleanArgumentMarshaler) {
            return ((BooleanArgumentMarshaler) argumentMarshaler).booleanValue;
        }
        return false;
    }

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        booleanValue = true;
    }
}
