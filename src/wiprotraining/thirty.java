package wiprotraining;


	import java.util.Scanner;

	// Functional Interface
	@FunctionalInterface
	interface MinFunction {
	    double minimum3(double a, double b, double c);
	}

	public class thirty {

	    // Static method using Math.min to find minimum of 3 numbers
	    public static double findMinimum(double a, double b, double c) {
	        return Math.min(a, Math.min(b, c));
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        // Read three float values
	        System.out.print("Enter first number: ");
	        double num1 = sc.nextDouble();

	        System.out.print("Enter second number: ");
	        double num2 = sc.nextDouble();

	        System.out.print("Enter third number: ");
	        double num3 = sc.nextDouble();

	        // Use method reference syntax to assign method to interface
	        MinFunction minFunc = thirty::findMinimum;

	        // Get and display minimum
	        double result = minFunc.minimum3(num1, num2, num3);
	        System.out.println("The smallest number is: " + result);

	        sc.close();
	    }
	}
	
