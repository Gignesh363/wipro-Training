package wiprotraining;

// Custom Exception class
class LowSalException extends Exception {
    public LowSalException(String message) {
        super(message);
    }
}

// Main Emp class
class Emp {
    private int empId;
    private String empName;
    private String designation;
    private double basic;
    private final double hra;

    // Constructor
    public Emp(int empId, String empName, String designation, double basic) throws LowSalException {
        if (basic < 50000) {
            throw new LowSalException("Basic salary must be at least 50000. Provided: " + basic);
        }

        this.empId = empId;
        this.empName = empName;
        this.designation = designation;
        this.basic = basic;
        this.hra = calculateHRA();
    }

    // Method to calculate HRA
    private double calculateHRA() {
        switch (designation) {
            case "Manager":
                return basic * 0.10;
            case "TeamLeader":
                return basic * 0.12;
            case "HR":
                return basic * 0.05;
            default:
                return 0.0;
        }
    }

    // Method to print employee details
    public void printDET() {
        System.out.println("----- Employee Details -----");
        System.out.println("ID           : " + empId);
        System.out.println("Name         : " + empName);
        System.out.println("Designation  : " + designation);
        System.out.println("Basic Salary : " + basic);
        System.out.println("HRA          : " + hra);
    }
}

// Main class to run the program
public class thirtythree {
    public static void main(String[] args) {
        try {
            Emp e1 = new Emp(101, "Alice", "Manager", 60000);
            e1.printDET();

            Emp e2 = new Emp(102, "Bob", "TeamLeader", 55000);
            e2.printDET();

            Emp e3 = new Emp(103, "Carol", "HR", 40000);  // Will throw exception
            e3.printDET();
        } catch (LowSalException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
//output:-
//----- Employee Details -----
//ID           : 101
//Name         : Alice
//Designation  : Manager
//Basic Salary : 60000.0
//HRA          : 6000.0
//----- Employee Details -----
//ID           : 102
//Name         : Bob
//Designation  : TeamLeader
//Basic Salary : 55000.0
//HRA          : 6600.0
//Exception: Basic salary must be at least 50000. Provided: 40000.0