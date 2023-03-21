package com.example.david_test.error;

import com.example.david_test.error.exceptions.BasePersonNotFoundException;
import com.example.david_test.error.exceptions.ChildNotFoundException;
import com.example.david_test.error.exceptions.PersonNotFoundException;
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

    @ExceptionHandler(value = PersonNotFoundException.class)
    public ResponseEntity<String> getPersonNotFound(PersonNotFoundException test) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(test.getMessage());
    }

    @ExceptionHandler(value = ChildNotFoundException.class)
    public ResponseEntity<String> getChildNotFound(ChildNotFoundException test) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(test.getMessage());
    }

    @ExceptionHandler(value = BasePersonNotFoundException.class)
    public ResponseEntity<String> getBasePersonNotFound(BasePersonNotFoundException test) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(test.getMessage());
    }

}
