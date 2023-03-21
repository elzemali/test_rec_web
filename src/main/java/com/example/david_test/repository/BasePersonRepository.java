package com.example.david_test.repository;

import com.example.david_test.models.BasePerson;
import com.example.david_test.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * auto define crud operation, with possibility to define  customize method,
 * @author  el amine
 * @version 0.1
 */
@Repository
public interface BasePersonRepository extends JpaRepository<BasePerson,String> {

    @Query(value= "select b from BasePerson b where b.firstName = :firstName and b.lastName = :lastName")
    public BasePerson findBasePersonByFirstNameAndLastName(String firstName, String lastName);

}
