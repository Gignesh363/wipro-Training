package wiprotraining;
import java.util.Scanner;
public class twentyfour {
	
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        double[] speeds = new double[5];
	        double sum = 0;

	        // Input speeds
	        System.out.println("Enter the speed of 5 bikers:");
	        for (int i = 0; i < 5; i++) {
	            System.out.print("Speed of Biker " + (i + 1) + ": ");
	            speeds[i] = sc.nextDouble();
	            sum += speeds[i];
	        }

	        double average = sum / 5;
	        System.out.println("\nAverage Speed: " + average);

	        // Display qualifying speeds
	        System.out.println("\nQualifying racers (speed > average):");
	        boolean found = false;
	        for (int i = 0; i < 5; i++) {
	            if (speeds[i] > average) {
	                System.out.println("Biker " + (i + 1) + " qualified with speed: " + speeds[i]);
	                found = true;
	            }
	        }

	        if (!found) {
	            System.out.println("No biker qualified.");
	        }

	        sc.close();
	    }
	}

