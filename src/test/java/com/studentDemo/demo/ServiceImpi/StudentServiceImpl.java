package com.studentDemo.demo.ServiceImpi;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentDemo.demo.DTO.StudentRequestDTO;
import com.studentDemo.demo.DTO.StudentResponseDTO;
import com.studentDemo.demo.Entity.Student;
import com.studentDemo.demo.Repository.StudentRepository;
import com.studentDemo.demo.Service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentResponseDTO createStudent(StudentRequestDTO studentRequestDTO) {

        // Student
        Student student1 = new Student();
        student1.setStudentName(studentRequestDTO.getStudentName());
        student1.setAge(studentRequestDTO.getAge());
        student1.setProgramName(studentRequestDTO.getProgramName());
        student1.setStudentAddress(studentRequestDTO.getStudentAddress());

        Student newstudent = studentRepository.save(student1);

        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        studentResponseDTO.setEnrollmentNO(newstudent.getEnrollmentNO());
        studentResponseDTO.setStudentName(newstudent.getStudentName());
        studentResponseDTO.setAge(newstudent.getAge());
        studentResponseDTO.setProgramName(newstudent.getProgramName());
        studentResponseDTO.setStudentAddress(newstudent.getStudentAddress());

        return studentResponseDTO;

        // // Employee
        // Student Employee1 = new Student();
        // Employee1.setEmployeeName(studentRequestDTO.getEmployeeName());
        // Employee1.setEmployeeAge(studentRequestDTO.getEmployeeAge());
        // Employee1.setEmployeeSalary(studentRequestDTO.getEmployeeSalary());
        // Employee1.setEmployeePoints(studentRequestDTO.getEmployeePoints());

        // Student newEmployee = studentRepository.save(Employee1);

        // StudentResponseDTO EmployeeResponseDTO = new StudentResponseDTO();
        // EmployeeResponseDTO.setEmployeeId(newEmployee.getEmployeeId());
        // EmployeeResponseDTO.setEmployeeName(newEmployee.getEmployeeName());
        // EmployeeResponseDTO.setEmployeeAge(newEmployee.getEmployeeAge());
        // EmployeeResponseDTO.setEmployeeSalary(newEmployee.getEmployeeSalary());
        // EmployeeResponseDTO.setEmployeePoints(newEmployee.getEmployeePoints());

        // return EmployeeResponseDTO;

        // Customer
        // Student Customer1 = new Student();
        // Customer1.setCustomerName(studentRequestDTO.getCustomerName());
        // Customer1.setCustomerFeedback(studentRequestDTO.getCustomerFeedback());
        // Customer1.setCustomerProductCount(studentRequestDTO.getCustomerProductCount());
        // Customer1.setTotalPrice(studentRequestDTO.getTotalPrice());

        // Student newCustomer = studentRepository.save(Customer1);

        // StudentResponseDTO CustomerResponseDTO = new StudentResponseDTO();
        // CustomerResponseDTO.setCustomerId(newCustomer.getCustomerId());
        // CustomerResponseDTO.setCustomerName(newCustomer.getCustomerName());
        // CustomerResponseDTO.setCustomerFeedback(newCustomer.getCustomerFeedback());
        // CustomerResponseDTO.setCustomerProductCount(newCustomer.getCustomerProductCount());
        // CustomerResponseDTO.setTotalPrice(newCustomer.getTotalPrice());

        // return CustomerResponseDTO;


    }

    @Override
    public StudentResponseDTO getStudent(UUID enrollmentNO) {
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        Student student = studentRepository.getReferenceById(enrollmentNO);

        studentResponseDTO.setEnrollmentNO(student.getEnrollmentNO());
        studentResponseDTO.setStudentName(student.getStudentName());
        studentResponseDTO.setAge(student.getAge());
        studentResponseDTO.setProgramName(student.getProgramName());
        studentResponseDTO.setStudentAddress(student.getStudentAddress());

        return studentResponseDTO;
    }

    @Override
    public String deleteStudent(UUID enrollmentNO){
        studentRepository.deleteById(enrollmentNO);
        return "Student Deleted Successfully";
    }
    



    @Override
    public StudentResponseDTO updateStudent(UUID enrollmentNO,StudentRequestDTO studentRequestDTO){
        Student student1 = studentRepository.getReferenceById(enrollmentNO);
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        
        student1.setStudentName(studentRequestDTO.getStudentName());
        student1.setAge(studentRequestDTO.getAge());
        student1.setProgramName(studentRequestDTO.getProgramName());
        student1.setStudentAddress(studentRequestDTO.getStudentAddress());
        
        Student newStudent = studentRepository.save(student1);

        studentResponseDTO.setEnrollmentNO(newStudent.getEnrollmentNO());
        studentResponseDTO.setStudentName(newStudent.getStudentName());
        studentResponseDTO.setAge(newStudent.getAge());
        studentResponseDTO.setProgramName(newStudent.getProgramName());
        studentResponseDTO.setStudentAddress(newStudent.getStudentAddress());

        return studentResponseDTO;
    }

}