package com.studentDemo.demo.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentDemo.demo.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, UUID> {

}