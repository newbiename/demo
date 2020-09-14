package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginController {

    @RequestMapping("login")
    public String login(String userName,String password){
        System.out.println(userName);
        System.out.println(password);
        return "success";
    }
}
