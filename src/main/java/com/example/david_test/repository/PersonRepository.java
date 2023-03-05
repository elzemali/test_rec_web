package com.example.david_test.repository;

import com.example.david_test.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person,String> {

    public Optional<Person>findDistincByFirstNameAndLastName(String firstName, String lastName);

}
