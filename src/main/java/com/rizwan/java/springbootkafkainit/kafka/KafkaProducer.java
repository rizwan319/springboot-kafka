package com.rizwan.java.springbootkafkainit.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);
    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String msg){
        log.info(String.format("Message sent {%s}", msg));
        kafkaTemplate.send("TopicOne", msg);
    }

    public void sendMessage(String msg, String topic){
        log.info(String.format("Message sent {%s} in topic {%s}", msg, topic));
        kafkaTemplate.send(topic, msg);
    }
}
