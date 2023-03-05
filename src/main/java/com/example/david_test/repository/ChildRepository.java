package com.example.david_test.repository;

import com.example.david_test.models.Child;
import com.example.david_test.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChildRepository extends JpaRepository<Child,String> {

    public Optional<Child>findDistincByFirstNameAndLastName(String firstName, String lastName);

}
