package com.alexm.cleancode.args;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * @author AlexM
 * Date: 3/12/20
 **/
public interface ArgumentMarshaler {
    void set(Iterator<String> currentArgument) throws ArgsException;
}
