package com.alexm.cleancode.args2;

/**
 * @author AlexM
 * Date: 3/14/20
 **/
public class ArgsException extends Exception {
    public enum ErrorCode {
        UNEXPECTED_ARGUMENT,
        INVALID_ARGUMENT_NAME,
        INVALID_ARGUMENT_FORMAT
    }

    public String errorMessage() {
        return null;
    }

    public ErrorCode errorCode() {
        return null;
    }

    public char errorArgumentId() {
        return 0;
    }

}
