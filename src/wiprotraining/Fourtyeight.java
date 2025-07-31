package wiprotraining;

@FunctionalInterface
interface EmployeeProcessor {
    void process(MyEmployee e);
}

class MyEmployee {
    int id;
    String name;
    double salary;

    public MyEmployee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}

public class Fourtyeight {

    public static void main(String[] args) {
        MyEmployee emp1 = new MyEmployee(1, "Ravi", 50000);
        MyEmployee emp2 = new MyEmployee(2, "Anjali", 60000);

        EmployeeProcessor printDetails = e ->
            System.out.println("Name: " + e.name + ", Salary: " + e.salary);

        EmployeeProcessor calculateBonus = e ->
            System.out.println("Bonus for " + e.name + ": " + (e.salary * 0.10));

        System.out.println("Employee Details:");
        printDetails.process(emp1);
        printDetails.process(emp2);

        System.out.println("\nBonus Calculation:");
        calculateBonus.process(emp1);
        calculateBonus.process(emp2);
    }
}
//output:Employee Details:
//	Name: Ravi, Salary: 50000.0
//	Name: Anjali, Salary: 60000.0
//
//	Bonus Calculation:
//	Bonus for Ravi: 5000.0
//	Bonus for Anjali: 6000.0

