package wiprotraining;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Fortythree {
    public static void main(String[] args) {
        // Use double backslashes \\ for Windows path
        String filePath = "C:\\Users\\kondr\\OneDrive\\Documents\\question.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("Reading from file:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
//output:-
//Reading from file:
//Hello, this is a sample text file.
//It contains multiple lines of text.
//You can use this file to test file reading in Java.
//Good luck with your practice!
