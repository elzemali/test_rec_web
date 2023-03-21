package com.example.david_test.error.exceptions;

/**
 *  PersonNotFoundExecpetion is exception throw if BasePerson is not found
 *  @author el amine
 *  @version 0.1
 */
public class PersonNotFoundException extends RuntimeException {

    public PersonNotFoundException(String message) {
        super(message);
    }

}
