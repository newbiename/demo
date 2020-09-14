package com.example.demo.sender;

import com.example.demo.config.RabbitMQConfig;
import com.example.demo.entity.UserEntity;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitmqSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sender(UserEntity userEntity) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE,userEntity);
    }
}
