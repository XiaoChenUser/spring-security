package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @RequestMapping("/echo")
    public String echo(){
        return "echo";
    }

    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }
    @RequestMapping("/normal")
    public String normal(){
        return "normal";
    }
    @RequestMapping("/user")
    public String user(){
        return "user";
    }
}
