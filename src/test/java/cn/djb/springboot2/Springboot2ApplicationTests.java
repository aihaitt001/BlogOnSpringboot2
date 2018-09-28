package cn.djb.springboot2;

import cn.djb.springboot2.domain.BlogArticle;
import cn.djb.springboot2.domain.BlogUser;
import cn.djb.springboot2.mapper.BlogUserMapper;
import cn.djb.springboot2.service.BlogArticleService;
import cn.djb.springboot2.service.BlogUserService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot2ApplicationTests {
    @Autowired
    BlogUserService userservice;
    @Autowired
    BlogArticleService service;

    //    @Test
//    public void contextLoads() {
//    }
//
    @Test
    public void testMybatis() {
//    BlogUser user  = new BlogUser();
//    user.setAdmin(1);
//    user.setEmail("106@gmail");
//    user.setPassword("123");
//    user.setSalt("salt");
//    user.setUsername("admin");
//    System.out.println("----------------------------------------------------------------");
//   System.out.println("add:"+userservice.add(user)) ;
        BlogUser newuser = new BlogUser();
        newuser.setId(userservice.checkUsername("admin").getId());
        newuser.setUsername("admin123");
        System.out.println("----------------------------------------------------------------");
        System.out.println("update:" + userservice.updateById(newuser));
        System.out.println("----------------------------------------------------------------");
        System.out.println("delete:" + userservice.deleteById(userservice.checkUsername("admin123").getId()));


    }
/*
*@Decription:json字符串必须双引号
*@name:
*@param:
*@returnType:
*@author: ovo
*@date: 2018/9/27  16:48
*/
    @Test
    public void testJackson() {

        BlogUser user = new BlogUser();
        user = userservice.checkUsername("test ");
        user.setPassword("test");
        user.setDeleted(0);

        String struser ="{\"id\":\"123\",username:\"null\"}";
        ObjectMapper objmapper = new ObjectMapper();
        //加了这个可以不在 属性上 用双引号(加了也行),但是值必须要加.
        //JsonParser.Feature.AUTO_CLOSE_SOURCE
        objmapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        try {
            BlogUser newuser = objmapper.readValue(struser, BlogUser.class);
            System.out.println("newuser" + newuser.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
