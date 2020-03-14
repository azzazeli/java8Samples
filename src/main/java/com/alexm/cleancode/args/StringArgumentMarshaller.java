package com.alexm.cleancode.args;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import static com.alexm.cleancode.args.ArgsException.ErrorCode.MISSING_STRING;


/**
 * @author AlexM
 * Date: 3/12/20
 **/
public class StringArgumentMarshaller implements ArgumentMarshaler {
    private String stringValue = "";

    public static String getValue(ArgumentMarshaler argumentMarshaler) {
        if (argumentMarshaler instanceof StringArgumentMarshaller) {
            return ((StringArgumentMarshaller)argumentMarshaler).stringValue;
        }
        return "";
    }

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        try {
            stringValue = currentArgument.next();
        } catch (NoSuchElementException e) {
            throw new ArgsException(MISSING_STRING);
        }
    }
}
