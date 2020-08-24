package com.example.demo.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.Serializable;

//@Component
public class MyfirstSchedule implements Serializable {

    @Autowired
    JavaMailSender javaMailSender;

    /**
     * 简单邮件
     */
    @Scheduled(cron = "0/1 * * * * ? ")
    public void testSchedule(){
        SimpleMailMessage msg=new SimpleMailMessage();
        msg.setSubject("阿龙");
        msg.setText("SB");
        msg.setTo("1430365719@qq.com");
        msg.setFrom("wwjx0791@163.com");
        javaMailSender.send(msg);
        System.out.println("发送成功");
    }

    /**
     * html邮件
     */
    @Scheduled
    public void testSchedule2() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
        messageHelper.setSubject("标题");
        messageHelper.setFrom("wwjx0791@163.com");
        messageHelper.setTo("1430365719@qq.com");
        messageHelper.setText("<h1>标题</h1><br/><p>这是内容</p>", true);
        javaMailSender.send(messageHelper.getMimeMessage());
    }
}
