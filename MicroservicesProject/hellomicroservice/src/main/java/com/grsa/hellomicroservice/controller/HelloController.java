package com.grsa.hellomicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @GetMapping("/hello")
    public String send() {
        kafkaTemplate.send("hello", "h");

        return "Добрый день";
    }
}
