package wiprotraining;

public class thirtyfour {
    private String empId;
    private String name;
    private int yearOfBirth;

    // Additional fields parsed from empId
    private String yearPart;
    private char designation;
    private String number;

    // Constructor
    public thirtyfour(String empId, String name, int yearOfBirth) {
        this.empId = empId;
        this.name = name;
        this.yearOfBirth = yearOfBirth;

        parseEmpId();  // Parse the ID once during construction
    }

    // Method to parse empId
    private void parseEmpId() {
        try {
            String[] parts = empId.split("-");
            if (parts.length == 3) {
                yearPart = parts[0];
                designation = parts[1].charAt(0);
                number = parts[2];
            } else {
                System.out.println("Invalid Employee ID format!");
            }
        } catch (Exception e) {
            System.out.println("Error parsing Employee ID: " + e.getMessage());
        }
    }

    // Display method
    public void displayDetails() {
        System.out.println("----- Employee Details -----");
        System.out.println("Employee Name     : " + name);
        System.out.println("Employee ID       : " + empId);
        System.out.println("Year of Birth     : " + yearOfBirth);
        System.out.println("Parsed Year       : " + yearPart);
        System.out.println("Designation Code  : " + designation);
        System.out.println("Number Code       : " + number);
        System.out.println("Designation Type  : " + (designation == 'F' ? "Faculty" : designation == 'S' ? "Staff" : "Unknown"));
    }

    // Main method for testing
    public static void main(String[] args) {
        thirtyfour e1 = new  thirtyfour("81-F-112", "Alice", 1981);
        thirtyfour e2 = new  thirtyfour("79-S-254", "Bob", 1979);

        e1.displayDetails();
        System.out.println();
        e2.displayDetails();
    }
}

//output:-
//----- Employee Details -----
//Employee Name     : Alice
//Employee ID       : 81-F-112
//Year of Birth     : 1981
//Parsed Year       : 81
//Designation Code  : F
//Number Code       : 112
//Designation Type  : Faculty
//
//----- Employee Details -----
//Employee Name     : Bob
//Employee ID       : 79-S-254
//Year of Birth     : 1979
//Parsed Year       : 79
//Designation Code  : S
//Number Code       : 254
//Designation Type  : Staff

