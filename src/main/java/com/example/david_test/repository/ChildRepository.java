package com.example.david_test.repository;

import com.example.david_test.models.Child;
import com.example.david_test.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChildRepository extends JpaRepository<Child,String> {
    @Query (value = "SELECT c FROM Child c, BasePerson b WHERE c.id = b.id and b.firstName = :firstName and " +
            " b.lastName = :lastName")
    Child findChildByFirstNameAndLastName(String firstName, String lastName);

}
