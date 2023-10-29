package com.rizwan.java.springbootkafkainit.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "TopicOne", groupId = "myGroup")
    public void consume(String msg){
        log.info(String.format("Message received -> {%s}", msg));
    }

}
