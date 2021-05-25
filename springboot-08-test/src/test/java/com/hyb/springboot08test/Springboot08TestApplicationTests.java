package com.hyb.springboot08test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot08TestApplicationTests {

    @Autowired
    JavaMailSender mailSender;

    @Test
    void contextLoads1() {
        //一个简单的邮件
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setSubject("你好啊");//主题
        mailMessage.setText("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");//文本
        mailMessage.setTo("3063687049hyb@gmail.com");
        mailMessage.setFrom("3063687049@qq.com");

        mailSender.send(mailMessage);
    }

    @Test
    void contextLoads2() throws MessagingException {
        //一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        //正文
        helper.setSubject("你好啊");
        helper.setText("<h1 style='color:red'>哈哈哈哈哈</h1>",true);

        //附件
        helper.addAttachment("1.jpg",new File("G:\\图片\\1.jpg"));
        helper.addAttachment("2.jpg",new File("G:\\图片\\2.jpg"));

        helper.setTo("3063687049hyb@gmail.com");
        helper.setFrom("3063687049@qq.com");


        mailSender.send(mimeMessage);
    }

}
