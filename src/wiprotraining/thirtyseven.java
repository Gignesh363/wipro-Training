package wiprotraining;




	import java.io.File;
	import java.io.FileWriter;
	import java.io.FileReader;
	import java.io.BufferedReader;
	import java.io.IOException;

	public class thirtyseven {

	    public static void main(String[] args) {
	        String fileName = "batchmates.txt";

	       
	        String[] batchMates = {
	            "Gignesh Kondreddy",
	            "Sita Raman",
	            "Ravi Kumar",
	            "Anjali Sharma",
	            "Rahul Mehra"
	        };

	        
	        try (FileWriter writer = new FileWriter(fileName)) {
	            for (String name : batchMates) {
	                writer.write(name + "\n");
	            }
	            System.out.println("Batchmates' names have been written to the file.");
	        } catch (IOException e) {
	            System.out.println("Error writing to file: " + e.getMessage());
	        }

	      
	        System.out.println("\n--- Batchmates List from File ---");
	        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                System.out.println("Name: " + line);
	            }
	        } catch (IOException e) {
	            System.out.println("Error reading file: " + e.getMessage());
	        }
	    }
	}

//	output:
//		Batchmates' names have been written to the file.
//
//		--- Batchmates List from File ---
//		Name: Gignesh Kondreddy
//		Name: Sita Raman
//		Name: Ravi Kumar
//		Name: Anjali Sharma
//		Name: Rahul Mehra

