package com.studentDemo.demo.DTO;

import java.util.UUID;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDTO {
    // Student
    UUID enrollmentNO;
    String studentName;
    int age;
    String programName;
    String studentAddress;

    // Employee
    // UUID employeeId;
    // String employeeName;
    // int employeeAge;
    // int employeeSalary;
    // int employeePoints;

    //Customer
    // UUID customerId;
    // String customerName;
    // String customerFeedback;
    // int customerProductCount;
    // int totalPrice;
}