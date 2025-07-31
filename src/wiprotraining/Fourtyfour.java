package wiprotraining;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

class EmployeeDetails {
    int id;
    String name;
    double salary;

    public EmployeeDetails(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class Fourtyfour {
    public static void main(String[] args) {
        List<EmployeeDetails> employees = new ArrayList<>();
        employees.add(new EmployeeDetails(1, "Ravi", 50000));
        employees.add(new EmployeeDetails(2, "Anjali", 70000));
        employees.add(new EmployeeDetails(3, "Kiran", 60000));
        employees.add(new EmployeeDetails(4, "Deepa", 70000));

        employees.sort(new Comparator<EmployeeDetails>() {
            @Override
            public int compare(EmployeeDetails e1, EmployeeDetails e2) {
                return Double.compare(e2.salary, e1.salary);
            }
        });

        System.out.println("Sorted by Salary (Descending):");
        for (EmployeeDetails e : employees) {
            System.out.println(e);
        }

        employees.sort((e1, e2) -> e1.name.compareToIgnoreCase(e2.name));

        System.out.println("\nSorted by Name (Alphabetical):");
        for (EmployeeDetails e : employees) {
            System.out.println(e);
        }
    }
}
//output:-
//Sorted by Salary (Descending):
//ID: 2, Name: Anjali, Salary: 70000.0
//ID: 4, Name: Deepa, Salary: 70000.0
//ID: 3, Name: Kiran, Salary: 60000.0
//ID: 1, Name: Ravi, Salary: 50000.0
//
//Sorted by Name (Alphabetical):
//ID: 2, Name: Anjali, Salary: 70000.0
//ID: 4, Name: Deepa, Salary: 70000.0
//ID: 3, Name: Kiran, Salary: 60000.0
//ID: 1, Name: Ravi, Salary: 50000.0


