package com.example.controller;

import com.example.dto.UserDto;
import com.example.model.entity.User;
import com.example.model.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;


@Controller
public class UserController {
    @Autowired
    IUserService iUserService;

    @GetMapping("")
    public String display(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "/index";

    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult, Model model) {
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/index";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            iUserService.save(user);
            List<User> list = iUserService.findAll();
            model.addAttribute("users", list);
            return "/list";
        }

    }
}
