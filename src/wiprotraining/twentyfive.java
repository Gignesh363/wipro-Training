package wiprotraining;
import java.util.Scanner;
public class twentyfive {
		    public static boolean isValid(double a, double b, double c) {
		        if (a + b > c && a + c > b && b + c > a) {
		            return true;
		        } else {
		            return false;
		        }
		    }

		 
		    public static double perimeter(double a, double b, double c) {
		        return a + b + c;
		    }

		    // Calculate area using Heron's formula
		    public static double area(double a, double b, double c) {
		        double s = (a + b + c) / 2;
		        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
		        return area;
		    }

		    // Main method
		    public static void main(String[] args) {
		        Scanner sc = new Scanner(System.in);

		        while (true) {
		            System.out.print("Enter side a (-1 to exit): ");
		            double a = sc.nextDouble();

		            if (a == -1) {
		                System.out.println("Bye~");
		                break;
		            }

		            System.out.print("Enter side b: ");
		            double b = sc.nextDouble();

		            System.out.print("Enter side c: ");
		            double c = sc.nextDouble();

		            if (isValid(a, b, c)) {
		                System.out.println("Perimeter: " + perimeter(a, b, c));
		                System.out.println("Area: " + area(a, b, c));
		            } else {
		                System.out.println("The input is invalid.");
		            }

		            System.out.println(); // Just for spacing
		        }

		        sc.close();
		    }
		
}
