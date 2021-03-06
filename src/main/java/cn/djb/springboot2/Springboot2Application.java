package cn.djb.springboot2;

import cn.djb.springboot2.mapper.BlogUserMapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Springboot2Application  {

 Logger logger= LogManager.getLogger(this.getClass().getName());

    public static void main(String[] args) {
        SpringApplication.run(Springboot2Application.class, args);

    }


    @Bean
   /*
   *@Decription:
   *@name:commandLineRunner
   *@param:[ctx]
   *@returnType:org.springframework.boot.CommandLineRunner
   *@author: ovo
   *@date: 2018/9/20  10:16
   */

    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            logger.info("Let's inspect the beans provided by Spring Boot:");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
//            logger.error("error");
////            logger.info("info");
////            logger.debug("debug");
////            logger.trace("trace");
            for (String beanName : beanNames) {
                System.out.println(beanName);


            }
        };
    }
}