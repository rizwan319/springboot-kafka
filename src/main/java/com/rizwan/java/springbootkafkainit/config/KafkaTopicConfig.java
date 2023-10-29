package com.rizwan.java.springbootkafkainit.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic myTopic(){
        return TopicBuilder.name("TopicOne")
                .build();
        // return TopicBuilder.name("TopicOne").partitions(10).build();
        //To create user defined partition
    }

    @Bean
    public NewTopic userJsonTopic(){
        return TopicBuilder.name("JsonTopicOne")
                .build();
    }

    /*
    @Bean
    public NewTopic userNewTopic(String topicName){
        return TopicBuilder.name(topicName).build();
    }*/
}
