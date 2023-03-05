package com.example.david_test.error.exceptions;

/**
 *  PersonNotFoundExecpetion is exception throw if BasePerson is not found
 *  @author el amine
 *  @version 0.1
 */
public class PersonNotFoundExecpetion extends Exception {

    public PersonNotFoundExecpetion(String message) {
        super(message);
    }

    public PersonNotFoundExecpetion(String message, Throwable cause) {
        super(message, cause);
    }

    public PersonNotFoundExecpetion(Throwable cause) {
        super(cause);
    }

    protected PersonNotFoundExecpetion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
