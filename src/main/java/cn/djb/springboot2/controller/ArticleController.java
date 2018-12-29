package cn.djb.springboot2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ArticleController {
    @RequestMapping("/body/allArticles")
    public ModelAndView articles(ModelAndView mav){
        mav.setViewName("/body/allArticles");
        return mav;
    }
    @RequestMapping("/body/article")
    public ModelAndView article(ModelAndView mav){
        mav.setViewName("/body/article");
        return mav;
    }
}
