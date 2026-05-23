package com.studentDemo.demo.ServiceImpi;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentDemo.demo.DTO.EmployeeRequestDTO;
import com.studentDemo.demo.DTO.EmployeeResponseDTO;
import com.studentDemo.demo.Entity.Employee;
import com.studentDemo.demo.Repository.EmployeeRepository;
import com.studentDemo.demo.Service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService  {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDTO) {
        // // Employee
        Employee Employee1 = new Employee();
        Employee1.setEmployeeName(employeeRequestDTO.getEmployeeName());
        Employee1.setEmployeeAge(employeeRequestDTO.getEmployeeAge());
        Employee1.setEmployeeSalary(employeeRequestDTO.getEmployeeSalary());
        Employee1.setEmployeePoints(employeeRequestDTO.getEmployeePoints());

        Employee newEmployee = employeeRepository.save(Employee1);

        EmployeeResponseDTO EmployeeResponseDTO = new EmployeeResponseDTO();
        EmployeeResponseDTO.setEmployeeId(newEmployee.getEmployeeId());
        EmployeeResponseDTO.setEmployeeName(newEmployee.getEmployeeName());
        EmployeeResponseDTO.setEmployeeAge(newEmployee.getEmployeeAge());
        EmployeeResponseDTO.setEmployeeSalary(newEmployee.getEmployeeSalary());
        EmployeeResponseDTO.setEmployeePoints(newEmployee.getEmployeePoints());

        return EmployeeResponseDTO;
    }

    @Override
    public EmployeeResponseDTO getEmployee(UUID employeeId) {
        EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
        Employee employee = employeeRepository.getReferenceById(employeeId);

        employeeResponseDTO.setEmployeeId(employee.getEmployeeId());
        employeeResponseDTO.setEmployeeName(employee.getEmployeeName());
        employeeResponseDTO.setEmployeeAge(employee.getEmployeeAge());
        employeeResponseDTO.setEmployeeSalary(employee.getEmployeeSalary());
        employeeResponseDTO.setEmployeePoints(employee.getEmployeePoints());

        return employeeResponseDTO;
    }

    @Override
    public String deleteEmployee(UUID employeeId){
        employeeRepository.deleteById(employeeId);
        return "Employee Deleted Successfully";
    }
    



    @Override
    public EmployeeResponseDTO updateEmployee(UUID employeeId,EmployeeRequestDTO employeeRequestDTO){
        Employee employee1 = employeeRepository.getReferenceById(employeeId);
        EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
        
        employee1.setEmployeeName(employeeRequestDTO.getEmployeeName());
        employee1.setEmployeeAge(employeeRequestDTO.getEmployeeAge());
        employee1.setEmployeeSalary(employeeRequestDTO.getEmployeeSalary());
        employee1.setEmployeePoints(employeeRequestDTO.getEmployeePoints());
        
        Employee newEmployee = employeeRepository.save(employee1);

        employeeResponseDTO.setEmployeeId(newEmployee.getEmployeeId());
        employeeResponseDTO.setEmployeeName(newEmployee.getEmployeeName());
        employeeResponseDTO.setEmployeeAge(newEmployee.getEmployeeAge());
        employeeResponseDTO.setEmployeeSalary(newEmployee.getEmployeeSalary());
        employeeResponseDTO.setEmployeePoints(newEmployee.getEmployeePoints());

        return employeeResponseDTO;
    }
}
