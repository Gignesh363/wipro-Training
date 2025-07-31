package wiprotraining;

import java.util.Optional;

class MissingFieldException extends Exception {
    public MissingFieldException(String message) {
        super(message);
    }
}

class EmployeeOptional {
    int id;
    String name;
    Optional<String> email;
    Optional<String> department;

    public EmployeeOptional(int id, String name, Optional<String> email, Optional<String> department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
    }

    public String getEmailOrDefault() {
        return email.orElse("No Email Provided");
    }

    public String getDepartmentOrThrow() throws MissingFieldException {
        return department.orElseThrow(() -> new MissingFieldException("Department is required!"));
    }
}

public class Fourtynine {
    public static void main(String[] args) {
        EmployeeOptional emp1 = new EmployeeOptional(1, "Ravi", Optional.of("ravi@example.com"), Optional.of("HR"));
        EmployeeOptional emp2 = new EmployeeOptional(2, "Anjali", Optional.empty(), Optional.empty());

        System.out.println("Employee 1 Email: " + emp1.getEmailOrDefault());
        try {
            System.out.println("Employee 1 Department: " + emp1.getDepartmentOrThrow());
        } catch (MissingFieldException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Employee 2 Email: " + emp2.getEmailOrDefault());
        try {
            System.out.println("Employee 2 Department: " + emp2.getDepartmentOrThrow());
        } catch (MissingFieldException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

//output:-Employee 1 Email: ravi@example.com
//Employee 1 Department: HR
//Employee 2 Email: No Email Provided
//Error: Department is required!
