package cn.djb.springboot2.service;

import cn.djb.springboot2.controller.HomeController;
import cn.djb.springboot2.domain.GetReport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


/**
 *对发送simplemessage的简单实现
 *
 *@author ovo
 *@date 2018/10/10 15:35
 *
 */
@Service
public class EmailServiceImpl implements EmailService {
    Logger logger = LogManager.getLogger(this.getClass().getName());

    @Autowired
    JavaMailSender sender;

    @Override
    public int send(GetReport report) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("1061295856@qq.com");
        message.setTo("1061295856@qq.com");
        message.setSubject("From LifeForFun");
        message.setText(report.toString());
        try {

            sender.send(message);
        } catch (Exception e) {
            logger.error("发送邮件出现问题::"+e.toString());
        }
        return 0;
    }
}
