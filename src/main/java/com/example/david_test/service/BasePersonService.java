package com.example.david_test.service;


import com.example.david_test.error.exceptions.BasePersonNotFoundExcpetion;
import com.example.david_test.models.BasePerson;
import com.example.david_test.models.Person;
import com.example.david_test.repository.BasePersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasePersonService {

    @Autowired
    BasePersonRepository basepersonRepository;

    public List<BasePerson> getAllPerson(){
        Page p =   basepersonRepository.findAll(Pageable.ofSize(10));
        return (List<BasePerson>) basepersonRepository.findAll();

    }

    public BasePerson getPersonById(String id){
        BasePerson basePerson = basepersonRepository.getReferenceById(id);
        if (basePerson == null) {
            throw new BasePersonNotFoundExcpetion("aucune personne trouvée !!");
        }
        return basepersonRepository.findById(id).get();
    }
    public BasePerson getPersonByLastAndFirstName(String firstName,String lastName){
        BasePerson basePerson = basepersonRepository.findBasePersonByFirstNameAndLastName(firstName,lastName);
        if (basePerson == null) {
            throw new BasePersonNotFoundExcpetion("aucune personne trouvée !!");
        }
        return basePerson;
    }

    public void delete(String id ){

        basepersonRepository.deleteById(id);
    }
}
