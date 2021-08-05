package com.example.model.entity.employee;

import com.example.model.entity.contract.Contract;

import javax.persistence.*;
import java.util.List;

@Entity
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long educationDegreeID;
    private String educationDegreeName;
    @OneToMany(mappedBy = "educationDegree")
    private List<Employee> employeeList;
}
