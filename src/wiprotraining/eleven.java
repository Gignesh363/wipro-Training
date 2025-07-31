package wiprotraining;

public class eleven {

	 public void add(int a, int b) {
	        int result = a + b;
	        System.out.println("Addition: " + result);
	    }

	    // Method to find difference
	    public void diff(int a, int b) {
	        int result = a - b;
	        System.out.println("Difference: " + result);
	    }

	    // Method to multiply
	    public void mul(int a, int b) {
	        int result = a * b;
	        System.out.println("Multiplication: " + result);
	    }

	    // Method to divide
	    public void div(int a, int b) {
	        if (b != 0) {
	            double result = (double) a / b;
	            System.out.println("Division: " + result);
	        } else {
	            System.out.println("Division by zero is not allowed.");
	        }
	    }
}
