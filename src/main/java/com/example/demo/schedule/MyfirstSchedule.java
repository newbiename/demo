package com.example.demo.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.Serializable;

//@Component
public class MyfirstSchedule implements Serializable {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    TemplateEngine templateEngine;

    /**
     * 简单邮件
     */
    //@Scheduled(cron = "0/1 * * * * ? ")
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
    //@Scheduled
    public void testSchedule2() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
        messageHelper.setSubject("标题");
        messageHelper.setFrom("wwjx0791@163.com");
        messageHelper.setTo("1430365719@qq.com");
        messageHelper.setText("<h1>标题</h1><br/><p>这是内容</p>", true);
        javaMailSender.send(messageHelper.getMimeMessage());
    }

    /**
     * template邮件
     */
    @Scheduled(cron = "0/1 * * * * ? ")
    public void templateSchedule() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
        messageHelper.setSubject("这是一个thymeleaf模板邮件");
        messageHelper.setTo("1430365719@qq.com");
        messageHelper.setFrom("wwjx0791@163.com");
        Context context = new Context();
        context.setVariable("name","这是一个新建的thymeleaf模板");
        context.setVariable("link","https://www.cnblogs.com/swzx-1213/");
        context.setVariable("image1","https://s1.ax1x.com/2020/04/14/JShDYt.th.jpg");
        String value = templateEngine.process("email.html",context);
        messageHelper.setText(value,true);
        javaMailSender.send(mimeMessage);
        System.out.println("发送邮件成功");
    }
}
