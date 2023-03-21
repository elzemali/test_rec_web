package com.example.david_test.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity mapping base_Person table, as super class, it define join as Inheritance strategy,
 * it use Lombok for getter , setter and constructor
 * @author el amine
 * @version 0.1
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasePerson {
    @Id
    @Column(name = "ID")
    protected   String id;

    @Column(name = "FIRST_NAME")
    protected   String firstName;

    @Column(name = "LAST_NAME")
    protected   String lastName;
}
