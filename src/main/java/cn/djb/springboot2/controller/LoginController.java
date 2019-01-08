package cn.djb.springboot2.controller;

import cn.djb.springboot2.domain.BlogUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam("loginuser") BlogUser loginuser){

        return "成功";
    }


}
