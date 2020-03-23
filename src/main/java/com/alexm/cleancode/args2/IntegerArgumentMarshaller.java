package com.alexm.cleancode.args2;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static com.alexm.cleancode.args2.ArgsException.ErrorCode.INVALID_INTEGER;
import static com.alexm.cleancode.args2.ArgsException.ErrorCode.MISSING_INTEGER;

/**
 * @author AlexM
 * Date: 3/23/20
 **/
public class IntegerArgumentMarshaller implements ArgumentMarshaler {
    private int integerValue;

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        String parameter = null;
        try {
            parameter = currentArgument.next();
            integerValue = Integer.parseInt(parameter);
        } catch (NoSuchElementException e) {
            throw new ArgsException(MISSING_INTEGER);
        } catch (NumberFormatException e) {
            throw new ArgsException(INVALID_INTEGER, parameter);
        }
    }

    @Override
    public Object get() {
        return integerValue;
    }
}
