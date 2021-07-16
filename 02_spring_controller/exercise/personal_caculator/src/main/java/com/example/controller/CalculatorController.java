package com.example.controller;

import com.example.model.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    CalculatorService calculatorService;
    @RequestMapping
    public String home(){
        return "/list";
    }
    @RequestMapping("/calculator")
    public String calculator(@RequestParam double numberOne, double numberSecond ,String calculator, Model model){
        String result=calculatorService.calculator(numberOne,numberSecond,calculator);
        model.addAttribute("result",result);
        return "/list";
    }
}
