package com.example.controller;

import com.example.service.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertCurrencyController {
    @Autowired
    ConvertService convertService;
    @GetMapping("/")
    public String greeting(){
        return "/list";
    }

    @PostMapping("/abc")
    public String convert(@RequestParam double money , @RequestParam  double exchangeMoney, @RequestParam double moneyChanged,Model model){
        double result =convertService.convert(money ,exchangeMoney,moneyChanged);
        model.addAttribute("result",result);
        return "/list";
    }
}
