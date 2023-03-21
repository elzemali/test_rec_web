package com.example.david_test.error.exceptions;

/**
 * BasePersonNotFoundExecpetion is exception throw if BasePerson is not found
 * @author el amine
 * @version 0.1
 */

public class BasePersonNotFoundException extends RuntimeException {

    public BasePersonNotFoundException(String message) {
        super(message);
    }

}
