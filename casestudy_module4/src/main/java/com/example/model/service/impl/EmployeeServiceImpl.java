package com.example.model.service.impl;


import com.example.model.entity.employee.Division;
import com.example.model.entity.employee.Education;
import com.example.model.entity.employee.Employee;
import com.example.model.entity.employee.Position;
import com.example.model.repository.employee.DivisionRepository;
import com.example.model.repository.employee.EducationRepository;
import com.example.model.repository.employee.EmployeeRepository;
import com.example.model.repository.employee.PositionRepository;
import com.example.model.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private DivisionRepository divisionRepository;
    @Autowired
    private EducationRepository educationRepository;
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void save(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public void remove(Long id) {
        this.employeeRepository.deleteById(id);
    }

    @Override
    public List<Division> listDivision() {
        return divisionRepository.findAll();
    }

    @Override
    public List<Education> listEducation() {
        return educationRepository.findAll();
    }

    @Override
    public List<Position> listPosition() {
        return positionRepository.findAll();
    }

    @Override
    public Page<Employee> findAllByNameContaining(String name, Pageable pageable) {
        return employeeRepository.findByNameContaining(name, pageable);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }
}
