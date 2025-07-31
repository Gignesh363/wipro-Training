package wiprotraining;

import java.util.*;
import java.util.stream.*;

class Employeex {
    int id;
    String name;
    String department;
    double salary;

    public Employeex(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String toString() {
        return id + " - " + name + " - " + department + " - " + salary;
    }
}

public class Fifty {
    public static void main(String[] args) {
        List<Employeex> employees = Arrays.asList(
            new Employeex(101, "Ravi", "HR", 50000),
            new Employeex(102, "Priya", "IT", 60000),
            new Employeex(103, "Arun", "HR", 55000),
            new Employeex(104, "Kavya", "IT", 70000),
            new Employeex(105, "Divya", "Sales", 45000)
        );

        // Q1: Print all employee names
        employees.stream().map(e -> e.name).forEach(System.out::println);

        // Q2: Employees with salary > 55000
        employees.stream().filter(e -> e.salary > 55000).forEach(System.out::println);

        // Q3: Count of HR department employees
        long hrCount = employees.stream().filter(e -> e.department.equals("HR")).count();
        System.out.println("HR count: " + hrCount);

        // Q4: Sort by salary descending
        employees.stream().sorted((e1, e2) -> Double.compare(e2.salary, e1.salary)).forEach(System.out::println);

        // Q5: Highest paid employee
        Employeex highestPaid = employees.stream().max(Comparator.comparingDouble(e -> e.salary)).orElse(null);
        System.out.println("Highest Paid: " + highestPaid);

        // Q6: Average salary
        double avgSalary = employees.stream().mapToDouble(e -> e.salary).average().orElse(0);
        System.out.println("Average Salary: " + avgSalary);

        // Q7: List of names
        List<String> names = employees.stream().map(e -> e.name).collect(Collectors.toList());
        System.out.println(names);

        // Q8: Group by department
        Map<String, List<Employeex>> groupedByDept = employees.stream()
            .collect(Collectors.groupingBy(e -> e.department));
        System.out.println(groupedByDept);

        // Q9: Total salary per department
        Map<String, Double> totalSalaryPerDept = employees.stream()
            .collect(Collectors.groupingBy(e -> e.department, Collectors.summingDouble(e -> e.salary)));
        System.out.println(totalSalaryPerDept);

        // Q10: IT department employees sorted by salary
        List<String> itNames = employees.stream()
            .filter(e -> e.department.equals("IT"))
            .sorted(Comparator.comparingDouble(e -> e.salary))
            .map(e -> e.name)
            .collect(Collectors.toList());
        System.out.println(itNames);

        // Q11: Any employee with salary < 40000
        boolean anyBelow40 = employees.stream().anyMatch(e -> e.salary < 40000);
        System.out.println("Any below 40000: " + anyBelow40);

        // Q12: Names joined with commas
        String commaNames = employees.stream().map(e -> e.name).collect(Collectors.joining(", "));
        System.out.println(commaNames);

        // Q13: Top 2 highest paid
        List<Employeex> top2 = employees.stream()
            .sorted((e1, e2) -> Double.compare(e2.salary, e1.salary))
            .limit(2)
            .collect(Collectors.toList());
        System.out.println(top2);

        // Q14: Skip first 2
        employees.stream().skip(2).forEach(System.out::println);

        // Q15: First 3 names
        employees.stream().limit(3).map(e -> e.name).forEach(System.out::println);

        // Q16: Min salary in HR
        Employeex minInHR = employees.stream()
            .filter(e -> e.department.equals("HR"))
            .min(Comparator.comparingDouble(e -> e.salary))
            .orElse(null);
        System.out.println("Min in HR: " + minInHR);

        // Q17: Partition salary > 55000
        Map<Boolean, List<Employeex>> partitioned = employees.stream()
            .collect(Collectors.partitioningBy(e -> e.salary > 55000));
        System.out.println(partitioned);

        // Q18: Average salary per department
        Map<String, Double> avgSalaryPerDept = employees.stream()
            .collect(Collectors.groupingBy(e -> e.department, Collectors.averagingDouble(e -> e.salary)));
        System.out.println(avgSalaryPerDept);

        // Q19: Sort by name then salary
        employees.stream()
            .sorted(Comparator.comparing((Employeex e) -> e.name).thenComparing(e -> e.salary))
            .forEach(System.out::println);

        // Q20: Map of ID to Name
        Map<Integer, String> idNameMap = employees.stream()
            .collect(Collectors.toMap(e -> e.id, e -> e.name));
        System.out.println(idNameMap);

        // Challenge 1: Name starts with D and ends with a
        employees.stream()
            .filter(e -> e.name.startsWith("D") && e.name.endsWith("a"))
            .forEach(System.out::println);

        // Challenge 2: Departments with more than one employee
        groupedByDept.entrySet().stream()
            .filter(entry -> entry.getValue().size() > 1)
            .forEach(entry -> System.out.println(entry.getKey()));

        // Challenge 3: Second highest salary
        Double secondHighest = employees.stream()
            .map(e -> e.salary)
            .distinct()
            .sorted(Comparator.reverseOrder())
            .skip(1)
            .findFirst()
            .orElse(0.0);
        System.out.println("Second Highest Salary: " + secondHighest);
    }
}
//output:-Ravi
//Priya
//Arun
//Kavya
//Divya
//102 - Priya - IT - 60000.0
//104 - Kavya - IT - 70000.0
//HR count: 2
//104 - Kavya - IT - 70000.0
//102 - Priya - IT - 60000.0
//103 - Arun - HR - 55000.0
//101 - Ravi - HR - 50000.0
//105 - Divya - Sales - 45000.0
//Highest Paid: 104 - Kavya - IT - 70000.0
//Average Salary: 56000.0
//[Ravi, Priya, Arun, Kavya, Divya]
//{Sales=[105 - Divya - Sales - 45000.0], HR=[101 - Ravi - HR - 50000.0, 103 - Arun - HR - 55000.0], IT=[102 - Priya - IT - 60000.0, 104 - Kavya - IT - 70000.0]}
//{Sales=45000.0, HR=105000.0, IT=130000.0}
//[Priya, Kavya]
//Any below 40000: false
//Ravi, Priya, Arun, Kavya, Divya
//[104 - Kavya - IT - 70000.0, 102 - Priya - IT - 60000.0]
//103 - Arun - HR - 55000.0
//104 - Kavya - IT - 70000.0
//105 - Divya - Sales - 45000.0
//Ravi
//Priya
//Arun
//Min in HR: 101 - Ravi - HR - 50000.0
//{false=[101 - Ravi - HR - 50000.0, 103 - Arun - HR - 55000.0, 105 - Divya - Sales - 45000.0], true=[102 - Priya - IT - 60000.0, 104 - Kavya - IT - 70000.0]}
//{Sales=45000.0, HR=52500.0, IT=65000.0}
//103 - Arun - HR - 55000.0
//105 - Divya - Sales - 45000.0
//104 - Kavya - IT - 70000.0
//102 - Priya - IT - 60000.0
//101 - Ravi - HR - 50000.0
//{101=Ravi, 102=Priya, 103=Arun, 104=Kavya, 105=Divya}
//105 - Divya - Sales - 45000.0
//HR
//IT
//Second Highest Salary: 60000.0