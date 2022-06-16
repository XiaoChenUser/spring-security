package com.example.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

@RestController
@RequestMapping("/demo")
public class DemoController {
    //这里 permitAll 必须登录
    @PermitAll
    @RequestMapping("/echo")
    public String echo(){
        return "echo";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }

    @PreAuthorize("hasAnyRole('ROLE_NORMAL')")
    @RequestMapping("/normal")
    public String normal(){
        return "normal";
    }

    @RequestMapping("/user")
    public String user(){
        return "user";
    }
}
