package com.studentDemo.demo.Service;

import java.util.UUID;

import com.studentDemo.demo.DTO.StudentRequestDTO;
import com.studentDemo.demo.DTO.StudentRequestDTO;
import com.studentDemo.demo.DTO.StudentResponseDTO;

public interface StudentService {
    StudentResponseDTO createStudent(StudentRequestDTO studentRequestDTO);
    
    StudentResponseDTO getStudent(UUID enrollmentNO);

    String deleteStudent(UUID enrollmentNO);

    StudentResponseDTO updateStudent(UUID enrollmentNO,StudentRequestDTO studentRequestDTO);
    
}