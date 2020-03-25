package com.alexm.cleancode.args2;

import static com.alexm.cleancode.args2.ArgsException.ErrorCode.OK;

/**
 * @author AlexM
 * Date: 3/23/20
 **/
public class ArgsException extends Exception {
    private static final ErrorCode DEFAULT_ERROR_CODE = OK;
    private static final char DEFAULT_ERROR_ARGUMENT = '\0';

    private final ErrorCode errorCode;
    private final char errorArgument;
    private final String errorParameter;

    public enum ErrorCode {
        MISSING_STRING,
        MISSING_INTEGER,
        INVALID_INTEGER,
        UNEXPECTED_ARGUMENT,
        INVALID_ARGUMENT_NAME,
        INVALID_DOUBLE,
        MISSING_DOUBLE,
        OK
    }

    public ArgsException(ErrorCode errorCode, char errorArgument, String errorParameter) {
        super();
        this.errorCode = errorCode == null ? DEFAULT_ERROR_CODE : errorCode;
        this.errorArgument = errorArgument;
        this.errorParameter = errorParameter;
    }

    public ArgsException(ErrorCode errorCode, String errorParameter) {
        this(errorCode, DEFAULT_ERROR_ARGUMENT, errorParameter);
    }

    public ArgsException(ErrorCode errorCode, char errorArgument) {
        this(errorCode, errorArgument, null);
    }

    public ArgsException(ErrorCode errorCode) {
        this(errorCode, DEFAULT_ERROR_ARGUMENT, null);
    }


    public String getErrorMessage() {
        switch (errorCode) {
            case UNEXPECTED_ARGUMENT: return String.format("Unexpected argument:%c found.", errorArgument);
            case MISSING_STRING: return String.format("Could not find string parameter for: -%c.", errorArgument);
            case MISSING_INTEGER:
                return String.format("Could not find integer parameter for: -%c", errorArgument);
            case INVALID_INTEGER:
                return String.format("Invalid value:%s provided for integer argument:-%c", errorParameter, errorArgument);
            case INVALID_ARGUMENT_NAME:
                return String.format("Bad character:%s in schema format.", errorArgument);
            case INVALID_DOUBLE:
                return String.format("Invalid value:%s provided for double argument:-%c", errorParameter, errorArgument);
            case MISSING_DOUBLE:
                return String.format("Could not find double parameter for argument -%c.", errorArgument);
            case OK:
                return "TILT: Should not get here";
        }
        return "";
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public String getErrorParameter() {
        return errorParameter;
    }
}
