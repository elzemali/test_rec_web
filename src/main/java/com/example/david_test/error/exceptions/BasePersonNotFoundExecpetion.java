package com.example.david_test.error.exceptions;

/**
 * BasePersonNotFoundExecpetion is exception throw if BasePerson is not found
 * @author el amine
 * @version 0.1
 */
public class BasePersonNotFoundExecpetion extends Exception {

    public BasePersonNotFoundExecpetion(String message) {
        super(message);
    }

    public BasePersonNotFoundExecpetion(String message, Throwable cause) {
        super(message, cause);
    }

    public BasePersonNotFoundExecpetion(Throwable cause) {
        super(cause);
    }

    protected BasePersonNotFoundExecpetion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
