package com.example.david_test.controller;

import com.example.david_test.error.exceptions.PersonNotFoundException;
import com.example.david_test.models.Person;
import com.example.david_test.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @Autowired
    PersonService service;

    /**
     *  Returns person from database as json object using id,
     *  and throw exception if don't exist
     * @param id unique string to identify  person
     * @return person fromatter in json
     * @throws PersonNotFoundException
     */
    @GetMapping("/api/test/person/{id}")
    public Person get(String id) throws PersonNotFoundException {
            return  service.getPersonById(id);
    }

    /**
     * Returns person from database using firstname or lastname, or both
     * else throws exception if don't exist
     * @param firstName
     * @param lastName
     * @return
     * @throws PersonNotFoundException
     */
    @GetMapping("/api/test/person/")
    public Person get(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName)
            throws PersonNotFoundException {
        return service.getPersonByFirstNameAndLastName(firstName,lastName);
    }

}
