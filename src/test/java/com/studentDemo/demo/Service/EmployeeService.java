package com.studentDemo.demo.Service;

import java.util.UUID;

import com.studentDemo.demo.DTO.EmployeeRequestDTO;
import com.studentDemo.demo.DTO.EmployeeResponseDTO;


public interface EmployeeService {
    EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDTO);
    
    EmployeeResponseDTO getEmployee(UUID employeeId);

    String deleteEmployee(UUID employeeId);

    EmployeeResponseDTO updateEmployee(UUID employeeId,EmployeeRequestDTO employeeRequestDTO);
}
