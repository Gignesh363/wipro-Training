package com.myapp.mockito.repository;

import com.myapp.mockito.entity.Student;
import java.util.Optional;

public interface StudentRepository {
    Optional<Student> findById(int id);
}
