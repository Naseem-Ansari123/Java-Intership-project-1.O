package com.studentDemo.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDTO {
    String employeeName;
    int employeeAge;
    int employeeSalary;
    int employeePoints;
}
