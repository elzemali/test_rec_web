package com.example.david_test.service;


import com.example.david_test.error.exceptions.ChildNotFoundException;
import com.example.david_test.models.Child;
import com.example.david_test.repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChildService {
    @Autowired
    ChildRepository childRepository;

    public List<Child> getAllChild(){
        return (List<Child>) childRepository.findAll();
    }

    public Child getChildById(String id) throws ChildNotFoundException {
        Child child = childRepository.getReferenceById(id);

        if (child == null) {
            throw new ChildNotFoundException("Aucun child trouvé");
        }
        return child;
    }

    public Child getChildByLastAndFirstName(String firstName,String lastName) throws ChildNotFoundException {
        Child child = childRepository.findChildByFirstNameAndLastName(firstName,lastName);

        if(child == null){
            throw new ChildNotFoundException("Child not exist");
        }
        return child;
    }

    public void delete(String id) throws ChildNotFoundException {
        Child child = childRepository.getReferenceById(id);
        if(child == null){
            throw new ChildNotFoundException("Child not exist");
        }
        else {
            childRepository.deleteById(id);
        }

    }
}
