package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @RequestMapping
    public String home(){
        return "/list";
    }
    @RequestMapping("/save")
    public String save(@RequestParam("condiments")String[]condiments, Model model){
        String result="";
        if(condiments == null){
            result="You don't choose sandwich ";
        }
        for (String temp:condiments){
            if(temp!= null){
                result += temp+" ";
            }
        }
        if("".equals(result)){
            result="You don't choose sandwich ";
        }
        model.addAttribute("result",result);
        return "/result";
    }
}
