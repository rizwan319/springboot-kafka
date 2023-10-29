package com.rizwan.java.springbootkafkainit.controller;

import com.rizwan.java.springbootkafkainit.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    private KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    //http:localhost:8080/api/v1/kafka/publish?message= hello Rizwan!
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String msg){
        kafkaProducer.sendMessage(msg);
        return ResponseEntity.ok(("Message Sent to the topic"));
    }

    //http:localhost:8080/api/v1/kafka/publish?message= hello Rizwan!?topic= TopicTwo
    //@GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String msg,
                                          @RequestParam("topic") String topic){
        kafkaProducer.sendMessage(msg, topic);
        return ResponseEntity.ok(("Message Sent to the topic given by user"));
    }
}
