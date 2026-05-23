package com.studentDemo.demo.DTO;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDTO {
    // Employee
    UUID employeeId;
    String employeeName;
    int employeeAge;
    int employeeSalary;
    int employeePoints;
}
