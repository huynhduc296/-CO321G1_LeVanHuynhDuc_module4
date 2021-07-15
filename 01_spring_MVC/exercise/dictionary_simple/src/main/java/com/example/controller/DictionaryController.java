package com.example.controller;

import com.example.model.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    DictionaryService dictionaryService;
    @GetMapping
    public String dictionary(){
        return "/list";
    }

    @PostMapping("/convert")
    public String convert(@RequestParam String input, Model model){
        String result =dictionaryService.convert(input);
        model.addAttribute("result",result);
        return "/list";
    }
}
