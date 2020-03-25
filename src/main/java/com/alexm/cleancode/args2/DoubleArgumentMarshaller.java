package com.alexm.cleancode.args2;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static com.alexm.cleancode.args2.ArgsException.ErrorCode.*;

/**
 * @author AlexM
 * Date: 3/24/20
 **/
public class DoubleArgumentMarshaller implements ArgumentMarshaler {
    private double doubleValue = 0.0;
    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        String parameter = null;
        try {
            parameter = currentArgument.next();
            doubleValue = Double.parseDouble(parameter);
        } catch (NumberFormatException e) {
            throw new ArgsException(INVALID_DOUBLE, parameter );

        } catch (NoSuchElementException e) {
            throw new ArgsException(MISSING_DOUBLE);
        }
    }

    @Override
    public Object get() {
        return doubleValue;
    }
}
