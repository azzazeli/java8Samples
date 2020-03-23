package com.alexm.cleancode.args2;

import java.util.Iterator;

/**
 * @author AlexM
 * Date: 3/23/20
 **/
public interface ArgumentMarshaler {
    void set(Iterator<String> currentArgument) throws ArgsException;
    Object get();

}
