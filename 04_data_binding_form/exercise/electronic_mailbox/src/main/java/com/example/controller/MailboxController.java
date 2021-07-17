package com.example.controller;

import com.example.model.bean.Mailbox;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MailboxController {
    @RequestMapping(value = "/mailbox")
    public String showFormMailbox(Model model){
        model.addAttribute("mailbox",new Mailbox());
        return "/list";
    }
    @PostMapping(value = "/update")
    public ModelAndView update(@ModelAttribute("mailbox") Mailbox mailbox){
        ModelAndView modelAndView = new ModelAndView("/show");
        modelAndView.addObject("mailbox", mailbox);
        return modelAndView;
    }
}
