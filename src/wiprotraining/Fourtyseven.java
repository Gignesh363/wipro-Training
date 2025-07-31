package wiprotraining;

class EmployeeData {
    int id;
    String name;
    double salary;

    public EmployeeData(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}

class InvalidSalaryException extends Exception {
    public InvalidSalaryException(String message) {
        super(message);
    }
}

class EmployeeService {
    public void validateSalary(double salary) throws InvalidSalaryException {
        if (salary < 0) {
            throw new InvalidSalaryException("Salary cannot be negative: " + salary);
        }
    }

    public void processSalary(EmployeeData emp) throws InvalidSalaryException {
        validateSalary(emp.salary);
    }

    public void startProcess(EmployeeData emp) throws InvalidSalaryException {
        processSalary(emp);
    }
}

public class Fourtyseven {
    public static void main(String[] args) {
        EmployeeData emp = new EmployeeData(1, "Ravi", -30000); // Negative salary to trigger exception
        EmployeeService service = new EmployeeService();

        try {
            service.startProcess(emp);
            System.out.println("Salary processed successfully for " + emp.name);
        } catch (InvalidSalaryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
//output:-Error: Salary cannot be negative: -30000.0
