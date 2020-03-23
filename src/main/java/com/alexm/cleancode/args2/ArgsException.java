package com.alexm.cleancode.args2;

import static com.alexm.cleancode.args2.ArgsException.ErrorCode.OK;

/**
 * @author AlexM
 * Date: 3/23/20
 **/
public class ArgsException extends Exception {
    private ErrorCode errorCode = OK;
    private char errorArgument = '\0';

    public enum ErrorCode {
        MISSING_STRING,
        MISSING_INTEGER,
        INVALID_INTEGER,
        UNEXPECTED_ARGUMENT,
        OK
    }
    public ArgsException(ErrorCode errorCode, char errorArgument) {
        this.errorCode = errorCode;
        this.errorArgument = errorArgument;
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


    public String getErrorMessage() {
        switch (errorCode) {
            case UNEXPECTED_ARGUMENT: return String.format("Unexpected argument:%c found.", errorArgument);
            case MISSING_STRING: return String.format("Could not find string parameter for: -%c.", errorArgument);
        }
        return "";
    }

    public void setErrorArgument(char errorArgument) {
        this.errorArgument = errorArgument;
    }
}
