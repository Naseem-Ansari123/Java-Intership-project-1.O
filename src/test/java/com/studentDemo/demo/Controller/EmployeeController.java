package com.studentDemo.demo.Controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentDemo.demo.DTO.EmployeeRequestDTO;
import com.studentDemo.demo.DTO.EmployeeResponseDTO;

import com.studentDemo.demo.Service.EmployeeService;


@RestController
@RequestMapping("/api")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/createEmployee") // http://localhost:8080/api/createEmployee
    public ResponseEntity<EmployeeResponseDTO> createEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO) {
        return new ResponseEntity<>(employeeService.createEmployee(employeeRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getEmployee")
    public ResponseEntity<EmployeeResponseDTO> getEmployee(@RequestParam UUID employeeId) {
        return new ResponseEntity<>(employeeService.getEmployee(employeeId), HttpStatus.OK);
    }

    @DeleteMapping("/deleteEmployee")
    public ResponseEntity<String> deleteEmployee(@RequestParam UUID employeeId) {
        return new ResponseEntity<>(employeeService.deleteEmployee(employeeId), HttpStatus.OK);
    }

    @PutMapping("/updateEmployee")
    public ResponseEntity<EmployeeResponseDTO> updateEmployee(@RequestParam UUID employeeId, @RequestBody EmployeeRequestDTO employeeRequestDTO) {

        return new ResponseEntity<>(employeeService.updateEmployee(employeeId,employeeRequestDTO),HttpStatus.OK);
    }
}
