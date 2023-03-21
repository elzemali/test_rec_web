package com.example.david_test.error.exceptions;

/**
 * ChildNotFoundExecpetion is is exception throw if Child is not found
 *
 * @author el amine
 * @version 0.1
 */
public class ChildNotFoundException extends RuntimeException {

    public ChildNotFoundException(String message) {
        super(message);
    }

}
