package com.testing;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;



// Dummy Student class
class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Repository interface
interface StudentRepository {
    Student findById(int id);
}

// Service class that uses the repository
class StudentService {
    private StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public String getStudentById(int id) {
        Student student = repository.findById(id);
        return student != null ? student.getName() : null;
    }
}

// Test class
public class junit4 {

    @Test
    public void testGetStudentById_ReturnsExpectedName() {
        // Step 1: Mock the repository
        StudentRepository mockRepo = mock(StudentRepository.class);

        // Step 2: Define behavior
        when(mockRepo.findById(1)).thenReturn(new Student(1, "John Doe"));

        // Step 3: Inject mock into service
        StudentService service = new StudentService(mockRepo);

        // Step 4: Call service method
        String name = service.getStudentById(1);

        // Step 5: Assert result
        assertEquals("John Doe", name);

        // Step 6: Verify method was called
        verify(mockRepo, times(1)).findById(1);
    }
}
