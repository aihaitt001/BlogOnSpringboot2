package cn.djb.springboot2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 *@decription 配置框架页面的跳转
 *@classname FramePageController
 *@author ovo
 *@date 2018/11/9 9:44
 *
 */
@RestController
public class FramePageController {

    @GetMapping("/frame/pageHeader")
    /**
     *@decription 设置页面head部分
     *@name pageHeader
     *@param [mav]
     *@return org.springframework.web.servlet.ModelAndView
     *@author ovo
     *@date 2018/11/14  16:54
     *
     */
    public ModelAndView  pageHeader(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/frame/pageHeader");
        return mav;
    }
    @GetMapping("/frame/pageFooter")
    /**
     *@decription 设置页面footer部分
     *@name pageFooter
     *@param [mav]
     *@return org.springframework.web.servlet.ModelAndView
     *@author ovo
     *@date 2018/11/14  16:55
     *
     */
    public ModelAndView pageFooter(ModelAndView mav){
        mav.setViewName("/frame/pageFooter");
        return mav;
    }
    @GetMapping("/body/contactMe")
    public ModelAndView contactMe(ModelAndView mav){
        mav.setViewName("/body/contactMe");
        return mav;
    }

}
