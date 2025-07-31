package wiprotraining;


	import java.util.Scanner;

	public class sixteen {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int[] marks = new int[3];
	        int i = 0;

	        while (i < 3) {
	            System.out.print("Enter the mark (0-100) for student " + (i + 1) + ": ");
	            int mark = sc.nextInt();

	            if (mark >= 0 && mark <= 100) {
	                marks[i] = mark;
	                i++;
	            } else {
	                System.out.println("Invalid input, try again...");
	            }
	        }

	        // Calculate average
	        double average = (marks[0] + marks[1] + marks[2]) / 3.0;

	        // Print average rounded to 2 decimal places
	        System.out.printf("The average is: %.2f\n", average);

	        sc.close();
	    }
	}

