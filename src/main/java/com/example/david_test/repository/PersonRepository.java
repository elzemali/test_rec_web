package com.example.david_test.repository;

import com.example.david_test.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person,String> {

    @Query ( value ="SELECT p FROM Person p, BasePerson b WHERE p.id = b.id and b.firstName = :firstName " +
            "and b.lastName = :lastName")
    Person findPersonByFirstNameAndLastName(String firstName, String lastName);

}
