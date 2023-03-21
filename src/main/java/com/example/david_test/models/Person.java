package com.example.david_test.models;


import com.example.david_test.converters.LocalDateTimeAttributeConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "ID")
public class Person extends BasePerson{
    @Column(name = "EYE_COLOR")
    private String eyeColor;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "DATE_OF_BIRTH" )
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    //@Temporal(value=TemporalType.DATE)
    private LocalDateTime dateOfBirth;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private long phone;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "COUNTRY")
    private String country;

    @Lob
    @Column(name = "ABOUT")
    private String about="";

    @Basic(optional = false)
    @Column(name = "FL_ACTIVE")
    private boolean isActive;

    @Column(name = "REGISTERED")
    private LocalDate registered;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable( name="person_children",
            joinColumns = @JoinColumn(name = "ID_PERSON"),
            inverseJoinColumns = @JoinColumn(name="ID_CHILD"))
    private List<Child> children;

}
