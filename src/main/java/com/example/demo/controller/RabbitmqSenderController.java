package com.example.demo.controller;


import com.example.demo.entity.UserEntity;


import com.example.demo.sender.RabbitmqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbitmq")
public class RabbitmqSenderController {

   @Autowired()
   private RabbitmqSender rabbitmqSender;

    @RequestMapping("/send")
    public String send(){
        UserEntity userEntity=new UserEntity();
        userEntity.setName("张三");
        userEntity.setUserId("1");
        rabbitmqSender.sender(userEntity);
        return "success";
    }
}
