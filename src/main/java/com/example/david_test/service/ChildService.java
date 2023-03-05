package com.example.david_test.service;


import com.example.david_test.error.exceptions.ChildNotFoundExecpetion;
import com.example.david_test.models.Child;
import com.example.david_test.models.Person;
import com.example.david_test.repository.ChildRepository;
import com.example.david_test.repository.PersonRepository;
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
        Page p =   childRepository.findAll(Pageable.ofSize(10));
        return (List<Child>) childRepository.findAll(Pageable.ofSize(10));

    }

    public Child getChildById(String id) throws ChildNotFoundExecpetion {
        Optional<Child> child = childRepository.findById(id);
        if(child.isEmpty()){
            throw new ChildNotFoundExecpetion("Child not exist");
        }
        else {
            return child.get();
        }

    }
    public Child getChildByLastAndFirstName(String firstName,String lastName) throws ChildNotFoundExecpetion {

        Optional<Child> child = childRepository.findDistincByFirstNameAndLastName(firstName,lastName);
        if(child.isEmpty()){
            throw new ChildNotFoundExecpetion("Child not exist");
        }
        else {
            return child.get();
        }
    }

    public void delete(String id ) throws ChildNotFoundExecpetion {
        Optional<Child> child = childRepository.findById(id);
        if(child.isEmpty()){
            throw new ChildNotFoundExecpetion("Child not exist");
        }
        else {
            childRepository.deleteById(id);
        }

    }
}
