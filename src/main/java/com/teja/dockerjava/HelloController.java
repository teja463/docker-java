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

    private final HelloRepository helloRepository;

    public HelloController(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    @GetMapping
    public HelloResponse hello(){
        Hello h = new Hello();
        h.setName("Test");
        helloRepository.save(h);
        String t = helloRepository.getTime();
        return new HelloResponse(h.getId(), t);
    }

    public record HelloResponse(Integer id, String name){

    }
}
