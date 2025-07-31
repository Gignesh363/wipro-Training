package wiprotraining;

	import java.io.*;
	import java.util.Scanner;

	// Employee class implements Serializable
	class Employee implements Serializable {
	    private int emp_id;
	    private String emp_name;
	    private transient double emp_sal; // Will not be serialized

	    // Constructor
	    public Employee(int emp_id, String emp_name, double emp_sal) {
	        this.emp_id = emp_id;
	        this.emp_name = emp_name;
	        this.emp_sal = emp_sal;
	    }

	    // Display method
	    public void display() {
	        System.out.println("---- Employee Details ----");
	        System.out.println("ID     : " + emp_id);
	        System.out.println("Name   : " + emp_name);
	        System.out.println("Salary : " + emp_sal);  // Will be 0.0 after deserialization
	    }
	}

	public class thirtyeight {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);


	        System.out.print("Enter Employee ID: ");
	        int id = sc.nextInt();
	        sc.nextLine(); // Clear newline

	        System.out.print("Enter Employee Name: ");
	        String name = sc.nextLine();

	        System.out.print("Enter Employee Salary: ");
	        double salary = sc.nextDouble();

	        // Create object
	        Employee emp = new Employee(id, name, salary);

	   
	        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.ser"))) {
	            oos.writeObject(emp);
	            System.out.println("\nEmployee object serialized successfully.\n");
	        } catch (IOException e) {
	            System.out.println("Serialization Error: " + e.getMessage());
	        }

	     
	        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee.ser"))) {
	            Employee deserializedEmp = (Employee) ois.readObject();
	            System.out.println("Deserialized Employee Object:");
	            deserializedEmp.display();  // emp_sal will be 0.0
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("Deserialization Error: " + e.getMessage());
	        }

	        sc.close();
	    }
	}


