package com.example.rest_for_test.controllers;

import com.example.rest_for_test.model.Person;
import com.example.rest_for_test.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private PersonService personService;

    @PostMapping("/persons")
    public ResponseEntity<?> create(@RequestBody Person person){
        personService.createPerson(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/persons")
    public ResponseEntity<List<Person>> read(){
        final List<Person> list = personService.getAll();
        return list != null &&  !list.isEmpty()
                ? new ResponseEntity<>(list, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/persons/{id}")
    public ResponseEntity<Person> read(@PathVariable(name = "id") Long id) {
        final Person person = personService.get(id);

        return person != null
                ? new ResponseEntity<>(person, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
