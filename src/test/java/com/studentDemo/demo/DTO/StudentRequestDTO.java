package com.studentDemo.demo.DTO;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDTO {
    // Student
    String studentName;
    int age;
    String programName;
    String studentAddress;

    // Employee
    // String employeeName;
    // int employeeAge;
    // int employeeSalary;
    // int employeePoints;

    // Customer
    // UUID customerId;
    // String customerName;
    // String customerFeedback;
    // int customerProductCount;
    // int totalPrice;
}