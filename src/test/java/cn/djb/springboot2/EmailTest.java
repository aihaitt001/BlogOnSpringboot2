package cn.djb.springboot2;

import cn.djb.springboot2.domain.GetReport;
import cn.djb.springboot2.service.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailTest {
@Autowired
    EmailService service;
@Test
public void send(){
service.send(new GetReport());

}

}
