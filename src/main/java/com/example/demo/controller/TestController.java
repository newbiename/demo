package com.example.demo.controller;


import com.example.demo.annotation.Log;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Log
    @RequestMapping("test/{str}")
    public String test(@PathVariable("str")String str){
        System.out.println("test"+str);
        return str;
    }
}
