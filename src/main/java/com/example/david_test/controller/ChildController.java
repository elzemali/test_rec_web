package com.example.david_test.controller;


import com.example.david_test.error.exceptions.ChildNotFoundExecpetion;
import com.example.david_test.models.Person;
import com.example.david_test.service.ChildService;
import com.example.david_test.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * ChildController handle requests concerning Child entity
 *
 */
@RestController
public class ChildController {

    @Autowired
    ChildService service;

    /**
     *  delete a child using id from database if exist else throw Exception,
     *  Id is specified in path
     * @param id
     * @throws ChildNotFoundExecpetion
     */
    @DeleteMapping("/api/test/{id}")
    public void deleteChild(@PathVariable("id") String id) throws ChildNotFoundExecpetion {
        service.delete(id);
    }

}
