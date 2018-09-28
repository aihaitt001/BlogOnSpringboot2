package cn.djb.springboot2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/*
*@Decription: WebMvcConfigurerAdapter已经过时
*  这个配置解决static下的文件找不到的问题,因为springboot在自定义activity后会把所有请求都通过DispatcherServlet
*@Classname:WebConfig
*@Author: ovo
*@Date:2018/9/25 17:34
*/

@Configuration
public class WebConfig  implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}