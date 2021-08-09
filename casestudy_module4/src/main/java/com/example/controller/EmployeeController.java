package com.example.controller;

import com.example.dto.EmployeeDto;
import com.example.model.entity.employee.*;
import com.example.model.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "employees")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @ModelAttribute("divisions")
    public List<Division> divisions () {
        return employeeService.listDivision();
    }

    @ModelAttribute("position")
    public List<Position> positions () {
        return employeeService.listPosition();
    }

    @ModelAttribute("education")
    public List<Education> educations () {
        return employeeService.listEducation();
    }

    @GetMapping(value = {""})
    public ModelAndView goList(@RequestParam("search") Optional<String> search,
                               @RequestParam("page") Optional<Integer> page) {
        Pageable pageable= PageRequest.of(page.orElse(0),3);
        Page<Employee> employees;
        ModelAndView modelAndView = new ModelAndView("/employee/list");
        if (search.isPresent()) {
            employees = employeeService.findAllByNameContaining(search.get(), pageable);
            modelAndView.addObject("search", search.get());
        } else {
            employees = employeeService.findAll(pageable);
        }
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping(value = "create")
    public String showFormCreate(Model model){
        model.addAttribute("employeeDto",new EmployeeDto());
        return "employee/create";
    }
}
