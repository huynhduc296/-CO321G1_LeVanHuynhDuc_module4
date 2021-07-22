package com.example.demo_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Hello {
    @GetMapping("hello")
    public String helloWord(){
        return "hello";
    }
}
