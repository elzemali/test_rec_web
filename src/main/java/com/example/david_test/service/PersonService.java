package com.example.david_test.service;


import com.example.david_test.error.exceptions.PersonNotFoundExecpetion;
import com.example.david_test.models.Person;
import com.example.david_test.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public List<Person> getAllPerson() {
        Page p = personRepository.findAll(Pageable.ofSize(10));
        return (List<Person>) personRepository.findAll(Pageable.ofSize(10));

    }

    public Person getPersonById(String id) throws PersonNotFoundExecpetion {
        Optional<Person> person = personRepository.findById(id);
        if (person.isEmpty()) {
            throw new PersonNotFoundExecpetion("je ne trouvze pas cette employe");
        } else {
            return person.get();
        }

    }

    public Person getPersonByLastAndFirstName(String firstName, String lastName) throws PersonNotFoundExecpetion {
        Optional<Person> person = personRepository.findDistincByFirstNameAndLastName(firstName, lastName);
        if (person.isEmpty()) {
            throw new PersonNotFoundExecpetion("je ne trouvze pas cette employe");
        } else {
            return person.get();
        }


    }

    public void delete(String id) throws PersonNotFoundExecpetion {
        Optional<Person> person = personRepository.findById(id);
        if (person.isEmpty()) {
            throw new PersonNotFoundExecpetion("je ne trouvze pas cette employe");
        } else {
            personRepository.deleteById(id);
        }

    }
}
