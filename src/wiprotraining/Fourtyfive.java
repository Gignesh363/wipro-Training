package wiprotraining;

import java.util.*;
import java.util.stream.Collectors;

class Student {
    int id;
    String name;
    String department;

    public Student(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
}

public class Fourtyfive {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Ravi", "CSE"));
        students.add(new Student(2, "Anjali", "ECE"));
        students.add(new Student(3, "Kiran", "CSE"));
        students.add(new Student(4, "Deepa", "EEE"));
        students.add(new Student(5, "Nikhil", "ECE"));

        Map<String, List<Student>> groupedByDept = students.stream()
            .collect(Collectors.groupingBy(s -> s.department));

        for (String dept : groupedByDept.keySet()) {
            System.out.println("Department: " + dept);
            for (Student s : groupedByDept.get(dept)) {
                System.out.println("  " + s.name);
            }
        }
    }
}
//output:-Department: EEE
//Deepa
//Department: CSE
//Ravi
//Kiran
//Department: ECE
//Anjali
//Nikhil

