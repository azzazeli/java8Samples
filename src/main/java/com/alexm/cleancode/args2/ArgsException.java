package com.alexm.cleancode.args2;

import static com.alexm.cleancode.args2.ArgsException.ErrorCode.OK;

/**
 * @author AlexM
 * Date: 3/23/20
 **/
public class ArgsException extends Exception {
    private ErrorCode errorCode = OK;
    private char errorArgument = '\0';
    private String errorParameter;

    public ArgsException(ErrorCode errorCode, String errorParameter) {
        this.errorCode = errorCode;
        this.errorParameter = errorParameter;
    }

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
            case MISSING_INTEGER:
                return String.format("Could not find integer parameter for: -%c", errorArgument);
            case INVALID_INTEGER:
                return String.format("Invalid value:%s provided for integer argument:-%c", errorParameter, errorArgument);
            case OK:
                return "TILT: Should not get here";
        }
        return "";
    }

    public void setErrorArgument(char errorArgument) {
        this.errorArgument = errorArgument;
    }
}
