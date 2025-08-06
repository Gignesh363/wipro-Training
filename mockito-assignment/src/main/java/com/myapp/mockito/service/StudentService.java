package com.myapp.mockito.service;

import com.myapp.mockito.entity.Student;
import com.myapp.mockito.repository.StudentRepository;
import java.util.Optional;

public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public String getStudentById(int id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.map(Student::getName).orElse("Not Found");
    }
}
