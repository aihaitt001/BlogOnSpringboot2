package cn.djb.springboot2.controller;

import cn.djb.springboot2.domain.BlogArticle;
import cn.djb.springboot2.service.BlogArticleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {
    Logger logger = LogManager.getLogger(HomeController.class);

    @Autowired
    BlogArticleService service;

    @GetMapping("/home")
    public ModelAndView home(ModelAndView mav) {
        mav.setViewName("home");
        return mav;
    }
    @GetMapping("/getHomeArticles")

    public List<BlogArticle> getHomeArticle()
    {
        logger.info("getHomeArticles");
        List<BlogArticle> list =service.listHomeArticles();
        logger.info(list+""+list.size());
        return    list;
    }



}
