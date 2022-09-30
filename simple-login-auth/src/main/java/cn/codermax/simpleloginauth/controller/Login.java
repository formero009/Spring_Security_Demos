package cn.codermax.simpleloginauth.controller;

import org.springframework.web.bind.annotation.*;

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