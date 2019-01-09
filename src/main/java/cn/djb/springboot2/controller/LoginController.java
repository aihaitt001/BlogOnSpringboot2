package cn.djb.springboot2.controller;

import cn.djb.springboot2.domain.BlogUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {
    Logger logger = LogManager.getLogger(LoginController.class);
//    @PostMapping("/login")
//    public String login(@RequestParam("username") String username,@RequestParam("password") String password){
//        logger.info(username+"__"+password);
//        return "登陆用户名:"+username;
//    }

    @GetMapping("/loginFailure")
    public String loginFailure(){
        return "登陆失败";
    }

    @GetMapping("/login")
    public ModelAndView getLoginPage(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }

}
