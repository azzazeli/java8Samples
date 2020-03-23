package com.alexm.cleancode.args2;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static com.alexm.cleancode.args2.ArgsException.ErrorCode.MISSING_STRING;

/**
 * @author AlexM
 * Date: 3/23/20
 **/
public class StringArgumentMarshaller implements ArgumentMarshaler {
    private String stringValue = "";

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        try {
            stringValue = currentArgument.next();
        } catch (NoSuchElementException e) {
            throw new ArgsException(MISSING_STRING);
        }
    }

    @Override
    public Object get() {
        return stringValue == null ? "" : stringValue;
    }
}
