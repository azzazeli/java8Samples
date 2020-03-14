package com.alexm.cleancode.args;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import static com.alexm.cleancode.args.ArgsException.ErrorCode.*;

/**
 * @author AlexM
 * Date: 3/12/20
 **/
public class IntegerArgumentMarshaller implements ArgumentMarshaler {
    private int intValue = 0;


    public static int getValue(ArgumentMarshaler argumentMarshaler) {
        if (argumentMarshaler instanceof  IntegerArgumentMarshaller) {
            return ((IntegerArgumentMarshaller) argumentMarshaler).intValue;
        }
        return 0;
    }

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        String parameter = null;
        try {
            parameter = currentArgument.next();
            intValue = Integer.parseInt(parameter);
        } catch (NoSuchElementException e) {
            throw new ArgsException(MISSING_INTEGER);
        }
        catch (NumberFormatException e) {
            throw new ArgsException(INVALID_INTEGER, parameter);
        }
    }
}
