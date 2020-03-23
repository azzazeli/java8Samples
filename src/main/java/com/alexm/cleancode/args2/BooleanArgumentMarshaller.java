package com.alexm.cleancode.args2;

import java.util.Iterator;

/**
 * @author AlexM
 * Date: 3/23/20
 **/
public class BooleanArgumentMarshaller implements ArgumentMarshaler {
    private boolean booleanValue;

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        this.booleanValue = true;
    }

    @Override
    public Object get() {
        return booleanValue;
    }

}
