package com.melashvili.elasticsearch.controllers;

import com.melashvili.elasticsearch.document.Person;
import com.melashvili.elasticsearch.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    private PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping
    public void save(@RequestBody Person person){
        service.save(person);
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable String id){
        return service.findById(id);
    }
}
