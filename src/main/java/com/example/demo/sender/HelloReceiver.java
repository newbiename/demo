package com.example.demo.sender;


import com.example.demo.config.RabbitMQConfig;
import com.example.demo.entity.UserEntity;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
@RabbitListener(queues = RabbitMQConfig.QUEUE)
public class HelloReceiver {

    @RabbitHandler
    public void process(UserEntity userEntity) {
        System.out.println("Receiver  : " + userEntity.toString());
    }

}