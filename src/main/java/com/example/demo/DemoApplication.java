package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.awt.*;
import java.awt.event.InputEvent;

@SpringBootApplication
@EnableScheduling
@EnableAutoConfiguration
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        try {
            int i=0;
            while(i<100000) {
                Robot robot = new Robot();
                robot.delay(100);
                robot.mousePress(InputEvent.BUTTON1_MASK);
                robot.delay(100);
                robot.mouseRelease(InputEvent.BUTTON1_MASK);
                ++i;
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

}
