package com.rizwan.java.springbootkafkainit.kafka;

import com.rizwan.java.springbootkafkainit.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "JsonTopicOne", groupId = "mygroup")
    public void consume(User user){
        log.info(String.format("Json message received  -> {%s}", user.toString()));
    }
}
