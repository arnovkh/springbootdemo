package com.example.demo.person;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService ) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.personService.getPersonById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<Person>> getAllPeople() {
        return ResponseEntity.ok(this.personService.getAllPeople());
    }

    @PostMapping("/")
    public ResponseEntity<Long> createPerson(@RequestBody Person person) {
        return ResponseEntity.ok(this.personService.createPerson(person));
    }

}
