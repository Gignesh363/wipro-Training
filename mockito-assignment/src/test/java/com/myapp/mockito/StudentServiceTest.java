package com.myapp.mockito;

import com.myapp.mockito.entity.Student;
import com.myapp.mockito.repository.StudentRepository;
import com.myapp.mockito.service.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    @Test
    void testGetStudentById() {
        // Mock the repository
        StudentRepository mockRepo = Mockito.mock(StudentRepository.class);

        // Dummy Student
        Student dummyStudent = new Student(1, "John Doe");

        // Define mock behavior
        when(mockRepo.findById(1)).thenReturn(Optional.of(dummyStudent));

        // Inject mock into service
        StudentService studentService = new StudentService(mockRepo);

        // Call service method
        String name = studentService.getStudentById(1);

        // Verify output
        assertEquals("John Doe", name);

        // Verify method call
        verify(mockRepo, times(1)).findById(1);
    }
}
