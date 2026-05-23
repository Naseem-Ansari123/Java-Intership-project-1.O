package com.studentDemo.demo.Entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID employeeId;
    
    @Column(name = "employee_name", nullable = true)
    String employeeName;

    @Column(name = "employee_age", nullable = true)
    int employeeAge;

    @Column(name = "employee_salary", nullable = true)
    int employeeSalary;

    @Column(name = "employee_points", nullable = true)
    int employeePoints;
}
