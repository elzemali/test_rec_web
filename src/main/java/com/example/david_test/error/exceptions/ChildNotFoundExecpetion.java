package com.example.david_test.error.exceptions;

/**
 * ChildNotFoundExecpetion is is exception throw if Child is not found
 * @author el amine
 * @version 0.1
 */
public class ChildNotFoundExecpetion extends Exception {

    public ChildNotFoundExecpetion(String message) {
        super(message);
    }

    public ChildNotFoundExecpetion(String message, Throwable cause) {
        super(message, cause);
    }

    public ChildNotFoundExecpetion(Throwable cause) {
        super(cause);
    }

    protected ChildNotFoundExecpetion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
