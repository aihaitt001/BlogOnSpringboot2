package cn.djb.springboot2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
/*
*@Decription: 安全性配置
*
* "@EnableWebMvcSecurity在spring security 5.0.8中已经过时了"
*@Classname:SecurityConfig
*@Author: ovo
*@Date:2018/9/20 10:01
*/


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    /*
    *@Decription:对HTTP请求的保护
    *@name:configure
    *@param:[http]
    *@return:void
    *@author: ovo
    *@Date: 2018/9/20  10:10
    */
    @Override
    protected void configure(HttpSecurity http) throws Exception{
    //默认配置  对所有请求都进行身份验证
    //http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
    http.
         formLogin().
            //loginPage("/login"). 自定义登陆连接
            and().logout().logoutUrl("/logout").logoutSuccessUrl("/").
         and().httpBasic().realmName("spring_security_demo").and()
            .authorizeRequests().antMatchers("/article").hasRole("user")
            .antMatchers("/user","/users").hasRole("admin")
            .anyRequest().permitAll()
            .and().csrf().disable();

    }


@Override
/*
*@Decription:配置用户认证
*@name:configure
*@param:[auth]
*@returnType:void
*@author: ovo
*@date: 2018/9/20  11:06
*/
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
    //使用内存储存用户信息
        auth.inMemoryAuthentication().
                withUser("admin").password("123").roles("admin","user")
                .and().withUser("test").password("test").roles("user");

}


    @Bean
    /* @FIXIT
    *@Decription:spring security在5.0之后已经过期了.暂时用明文密码，还是要用passwordENCODER
    *@name:passwordEncoder
    *@param:[]
    *@returnType:org.springframework.security.crypto.password.NoOpPasswordEncoder
    *@author: ovo
    *@date: 2018/9/20  15:56
    */
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }


}
