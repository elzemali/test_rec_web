package com.example.david_test.service;


import com.example.david_test.error.exceptions.PersonNotFoundException;
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
        return (List<Person>) personRepository.findAll();
    }

    public Person getPersonById(String id) throws PersonNotFoundException {
        try {
            Person person = personRepository.findById(id).get();
            return person;
        } catch (java.util.NoSuchElementException ex) {
            throw new PersonNotFoundException("Aucune personne trouvée !");
        }
    }

    public Person getPersonByFirstNameAndLastName(String firstName, String lastName) throws PersonNotFoundException {
        try {
            Person person = personRepository.findPersonByFirstNameAndLastName(firstName, lastName);
            if (person == null) {
                throw new PersonNotFoundException("Aucune personne trouvée !");
            }
            return person;
        } catch (java.util.NoSuchElementException ex) {
            throw new PersonNotFoundException("Aucune personne trouvée !");
        }
    }

    public void delete(String id) throws PersonNotFoundException {
        try {
            Person person = getPersonById(id);
            personRepository.deleteById(id);
        } catch (PersonNotFoundException ex){
            throw new PersonNotFoundException("Impossible de supprimer, person n'existe pas");
        }
    }
}
