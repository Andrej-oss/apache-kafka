package com.example.apachekafka.controller;


import com.example.apachekafka.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProducerController {

    KafkaTemplate<String, Book> kafkaTemplate;

    @Autowired
    public ProducerController(KafkaTemplate<String, Book> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public static final String TOPIC = "NewTopic";

//    @GetMapping("/publish/{message}")
//    public String publishMessage(@PathVariable String message){
//        kafkaTemplate.send(TOPIC, message);
//        return "Published message successfully";
//    }
    @PostMapping("/publish")
    public String publishBook(@RequestBody Book book){
        kafkaTemplate.send(TOPIC, book);
        return "Published message successfully";
    }
}
