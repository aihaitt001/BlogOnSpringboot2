package cn.djb.springboot2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/users")
    public String users(){
        return "iusers list";
    }
    @GetMapping("/user")
    public String getUser(){
        return "get user";
    }
    @PostMapping("/user")
    public String postUser(){
        return "post user";
    }
}
