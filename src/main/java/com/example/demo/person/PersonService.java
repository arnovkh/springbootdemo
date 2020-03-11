package com.example.demo.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    public final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person getPersonById(Long id) {
        return this.personRepository.findById(id).orElse(null);
    }

    public Long createPerson(Person person) {
        return this.personRepository.save(person).getId();
    }

    public List<Person> getAllPeople() {
        return this.personRepository.findAll();
    }

}
