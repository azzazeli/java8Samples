package com.alexm.cleancode.args2;

import static com.alexm.cleancode.args2.ArgsException.ErrorCode.OK;

/**
 * @author AlexM
 * Date: 3/23/20
 **/
public class ArgsException extends Exception {
    private ErrorCode errorCode = OK;

    public enum ErrorCode {
        MISSING_STRING, MISSING_INTEGER, INVALID_INTEGER, OK
    }

    public ArgsException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ArgsException(String s) {
        super(s);
    }

    public ArgsException() {
        super();
    }


    public String getErrorMessage() throws ArgsException {
        return null;
    }
}
