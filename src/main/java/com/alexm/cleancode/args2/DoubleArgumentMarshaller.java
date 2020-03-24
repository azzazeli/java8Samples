package com.alexm.cleancode.args2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author AlexM
 * Date: 3/24/20
 **/
public class DoubleArgumentMarshaller implements ArgumentMarshaler {
    private double doubleValue = 0.0;
    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        try {
            doubleValue = Double.parseDouble(currentArgument.next());
        } catch (NumberFormatException e) {

        } catch (NoSuchElementException e) {

        }
    }

    @Override
    public Object get() {
        return doubleValue;
    }
}
