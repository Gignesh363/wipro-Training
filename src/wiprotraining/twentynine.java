package wiprotraining;

import java.util.Scanner;
import java.util.NoSuchElementException;

public class twentynine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Read input
            System.out.print("Enter Register Number: ");
            String regNo = sc.nextLine();

            System.out.print("Enter Mobile Number: ");
            String mobileNo = sc.nextLine();

            // Check length of Register Number
            if (regNo.length() != 9) {
                throw new IllegalArgumentException("Register number must be 9 characters");
            }

            // Check length of Mobile Number
            if (mobileNo.length() != 10) {
                throw new IllegalArgumentException("Mobile number must be 10 digits");
            }

            // Check if Mobile Number contains only digits
            if (!mobileNo.matches("\\d+")) {
                throw new IllegalArgumentException("Mobile number must contain digits only");
            }

            // Check if Register Number contains only letters and digits
            if (!regNo.matches("[a-zA-Z0-9]+")) {
                throw new NoSuchElementException("Register number must be alphanumeric");
            }

            // If all checks passed
            System.out.println("valid");

        } catch (IllegalArgumentException | NoSuchElementException e) {
            System.out.println("invalid");
            // Optional: System.out.println(e.getMessage());
        }

        sc.close();
    }
}
