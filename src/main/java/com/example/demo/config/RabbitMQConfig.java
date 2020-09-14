package com.example.demo.config;


import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE = "direct_queue";
    public static final String TOPICQUEUE="topic_queue";

    @Bean
    public Queue directQueue(){
        return new Queue(QUEUE,true);
    }

    @Bean
    public Queue topicQueue(){
        return new Queue(TOPICQUEUE,true);
    }

    @Bean
    public TopicExchange getTopicExchange(){
        return new TopicExchange("topicExchange");
    }

    @Bean
    public FanoutExchange getFanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

}
