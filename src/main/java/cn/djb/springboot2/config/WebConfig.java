package cn.djb.springboot2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
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

    @Value(value = "${upload.files.path}")
    private String uploadFilesPath ;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("public/image/**").addResourceLocations("file:"+uploadFilesPath+"//");
        registry.addResourceHandler("static/**").addResourceLocations("classpath:static/");
    }

    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(responseBodyConverter());
        // 这里必须加上加载默认转换器，不然bug玩死人，并且该bug目前在网络上似乎没有解决方案
        // 百度，谷歌，各大论坛等。你可以试试去掉。

        //addDefaultHttpMessageConverters(converters);

    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }



}