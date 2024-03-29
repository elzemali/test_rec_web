package com.example.david_test.service;


import com.example.david_test.error.exceptions.BasePersonNotFoundException;
import com.example.david_test.models.BasePerson;
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
        return (List<BasePerson>) basepersonRepository.findAll();
    }

    public BasePerson getPersonById(String id){
        BasePerson basePerson = basepersonRepository.getReferenceById(id);

        if (basePerson == null) {
            throw new BasePersonNotFoundException("aucune personne trouvée !!");
        }
        return basePerson;
    }
    public BasePerson getPersonByLastAndFirstName(String firstName,String lastName){
        BasePerson basePerson = basepersonRepository.findBasePersonByFirstNameAndLastName(firstName,lastName);

        if (basePerson == null) {
            throw new BasePersonNotFoundException("aucune personne trouvée !!");
        }
        return basePerson;
    }

    public void delete(String id ){
        basepersonRepository.deleteById(id);
    }
}
