package wiprotraining;




	import java.util.Scanner;


	class InvalidEmployeeCodeException extends Exception {
	    public InvalidEmployeeCodeException(String message) {
	        super(message);
	    }
	}

	// Employee Class
	class Employee {
	    private String empId;
	    private String name;
	    private int yearOfBirth;

	    private String yearPart;
	    private char designation;
	    private String number;

	    public Employee(String empId, String name, int yearOfBirth) throws InvalidEmployeeCodeException {
	        if (!isValidEmpCode(empId)) {
	            throw new InvalidEmployeeCodeException("Invalid Employee Code Format: " + empId);
	        }

	        this.empId = empId;
	        this.name = name;
	        this.yearOfBirth = yearOfBirth;

	        parseEmpCode();
	    }

	    // Validate empId format
	    private boolean isValidEmpCode(String empId) {
	        return empId.matches("\\d{2}-[FS]-\\d{3}");
	    }

	    // Parse empId
	    private void parseEmpCode() {
	        String[] parts = empId.split("-");
	        yearPart = parts[0];
	        designation = parts[1].charAt(0);
	        number = parts[2];
	    }

	    // Display employee details
	    public void displayDetails() {
	        System.out.println("----- Employee Details -----");
	        System.out.println("Name              : " + name);
	        System.out.println("Year of Birth     : " + yearOfBirth);
	        System.out.println("Employee Code     : " + empId);
	        System.out.println("Parsed Year       : " + yearPart);
	        System.out.println("Designation Code  : " + designation);
	        System.out.println("Designation Type  : " + (designation == 'F' ? "Faculty" : "Staff"));
	        System.out.println("Number Code       : " + number);
	    }
	}

	// Main Class
	public class thirtyfive {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        try {
	            System.out.print("Enter Employee Name: ");
	            String name = sc.nextLine();

	            System.out.print("Enter Year of Birth: ");
	            int year = sc.nextInt();
	            sc.nextLine(); // consume newline

	            System.out.print("Enter Employee Code (Format: YY-F/S-NNN): ");
	            String empCode = sc.nextLine();

	            Employee emp = new Employee(empCode, name, year);
	            emp.displayDetails();

	        } catch (InvalidEmployeeCodeException e) {
	            System.out.println("Error: " + e.getMessage());
	        } catch (Exception e) {
	            System.out.println("Unexpected Error: " + e.getMessage());
	        } finally {
	            sc.close();
	        }
	    }
	}

//output:-Enter Employee Name: Gignesh
//Enter Year of Birth: 2003
//Enter Employee Code (Format: YY-F/S-NNN): 03-S-112
//----- Employee Details -----
//Name              : Gignesh
//Year of Birth     : 2003
//Employee Code     : 03-S-112
//Parsed Year       : 03
//Designation Code  : S
//Designation Type  : Staff
//Number Code       : 112

