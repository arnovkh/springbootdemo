package com.example.demo.api.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/hello")
public class HelloWorldController {

    @GetMapping()
    public ResponseEntity<String> returnHelloWorld() {
        return ResponseEntity.ok("Hello world");
    }

}
