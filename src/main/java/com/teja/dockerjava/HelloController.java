package com.teja.dockerjava;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@CrossOrigin
@RequestMapping("/hello")
@RestController
public class HelloController {

    @GetMapping
    public HelloResponse hello(){
        return new HelloResponse("Spring Boot", LocalDateTime.now());
    }

    public record HelloResponse(String name, LocalDateTime time){

    }
}
