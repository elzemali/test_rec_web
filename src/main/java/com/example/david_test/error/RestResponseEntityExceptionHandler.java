package com.example.david_test.error;

import com.example.david_test.error.exceptions.BasePersonNotFoundExecpetion;
import com.example.david_test.error.exceptions.ChildNotFoundExecpetion;
import com.example.david_test.error.exceptions.PersonNotFoundExecpetion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * RestResponseEntityExceptionHandler handle exception define by ExceptionHandler
 * @author el amine
 *  @version 0.1
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    /**
     *  Catch PersonNotFoundExecpetion  and modify Response body
     * @param test
     * @return
     */

    @ExceptionHandler(value = PersonNotFoundExecpetion.class)
    public ResponseEntity<String> getPersonNotFound(PersonNotFoundExecpetion test) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(test.getMessage());
    }

    @ExceptionHandler(value = ChildNotFoundExecpetion.class)
    public ResponseEntity<String> getChildNotFound(ChildNotFoundExecpetion test) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(test.getMessage());
    }

    @ExceptionHandler(value = BasePersonNotFoundExecpetion.class)
    public ResponseEntity<String> getBasePersonNotFound(BasePersonNotFoundExecpetion test) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(test.getMessage());
    }



}
