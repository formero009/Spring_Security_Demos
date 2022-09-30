package com.example.rememberme.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1")
@RestController
public class Login {

    @ResponseBody
    @GetMapping("/service")
    public String SomeService(){
        return "service page";
    }

    @RequestMapping("home")
    public String GotoHome(){
        return "redirect:home.html";
    }
}