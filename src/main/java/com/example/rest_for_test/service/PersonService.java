package com.example.rest_for_test.service;

import com.example.rest_for_test.model.Person;
import com.example.rest_for_test.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;
    public void createPerson(Person person){
        if(checkPerson(person)) personRepository.save(person);
        else throw new IllegalArgumentException("person's data is null!");
    }
    public void updatePerson(Person person){
        if(checkPerson(person)) {
            if (personRepository.existsById(person.getId())) personRepository.save(person);
            else throw new EntityExistsException("no person found by ID");
        }else throw new IllegalArgumentException("person's data is null!");

    }
    public boolean checkPerson(Person person){
        if(person.getName() == null || person.getAge() == null || person.getSurname() == null ) return false;
        else return true;
    }
    public List<Person> getAll(){
        List<Person> list = new ArrayList<>();
        personRepository.findAll().forEach(list::add);
        return list;
    }
    public Person get(Long id){
        return personRepository.findById(id).get();
    }
}
