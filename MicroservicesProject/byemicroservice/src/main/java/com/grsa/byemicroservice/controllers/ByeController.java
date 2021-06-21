package com.grsa.byemicroservice.controllers;

import com.grsa.byemicroservice.model.Counter;
import com.grsa.byemicroservice.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ByeController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private CounterService counterService;

    @GetMapping("/bye")
    public String send() {
        kafkaTemplate.send("bye", "b");
        counterService.increaseCounter("bye");

        int count = counterService.getCount("hello");
        return "Всего доброго! Вы здоровались " + count + " количество раз";
    }

}