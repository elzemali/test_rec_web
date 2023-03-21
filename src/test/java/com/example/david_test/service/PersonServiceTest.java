package com.example.david_test.service;

import com.example.david_test.error.exceptions.PersonNotFoundException;
import com.example.david_test.models.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonServiceTest {
    @Autowired
    PersonService personService;

    @Test
    void getPersonById() {
        String id = "5e143deabe3dae51de4b130b";
        Person p = personService.getPersonById(id);
        assertEquals(p.getId(),id);
    }

    @Test
    void getPersonByIdException() {
        String id = "5";
        Throwable exception = assertThrows(PersonNotFoundException.class, () -> personService.getPersonById(id));
        assertEquals("Aucune personne trouvée !", exception.getMessage());
    }

    @Test
    void getPersonByLastAndFirstName() {
        String firstName = "Sue";
        String lastName  = "Cleveland";
        Person p = personService.getPersonByFirstNameAndLastName(firstName,lastName);
        assertEquals(p.getFirstName(),firstName);
        assertEquals(p.getLastName(),lastName);
    }
    @Test
    void getPersonByLastAndFirstNameThrowException() {
        String firstName = "S";
        String lastName  = "C";
        Throwable exception = assertThrows(PersonNotFoundException.class,
                () -> personService.getPersonByFirstNameAndLastName(firstName,lastName));
        assertEquals("Aucune personne trouvée !", exception.getMessage());
    }

}