package com.example.paginationjpa.controller;

import com.example.paginationjpa.model.Person;
import com.example.paginationjpa.repository.PersonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/people")
public class PersonController {

private final PersonRepository personRepository;

public PersonController (PersonRepository personRepository){
    this.personRepository=personRepository;
}

@GetMapping
    public Page<Person> fiindAll(@RequestParam int page, @RequestParam int size){
    PageRequest pr = PageRequest.of(page,size);
    return personRepository.findAll(pr);
}
}
