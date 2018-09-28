package cn.djb.springboot2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {
    @RequestMapping("/articles")
    public String articles(){
        return "articles list";
    }
    @RequestMapping("/article")
    public String article(){
        return "article";
    }
}
