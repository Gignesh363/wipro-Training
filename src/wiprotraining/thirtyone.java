package wiprotraining;


	import java.util.Scanner;
	import java.util.InputMismatchException;
	
	public class thirtyone {
		
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        // Demonstrate InputMismatchException
	        try {
	            System.out.print("Enter an integer: ");
	            int num = sc.nextInt(); // Will throw InputMismatchException if not an integer
	            System.out.println("You entered: " + num);
	        } catch (InputMismatchException e) {
	            System.out.println("InputMismatchException caught: Please enter a valid integer.");
	        }

	        sc.nextLine(); // Clear the buffer before reading a string

	        // Demonstrate StringIndexOutOfBoundsException
	        try {
	            System.out.print("Enter a word: ");
	            String word = sc.nextLine();
	            System.out.print("Enter an index to access character: ");
	            int index = sc.nextInt(); // If index is out of bounds, exception will occur
	            System.out.println("Character at index " + index + " is: " + word.charAt(index));
	        } catch (StringIndexOutOfBoundsException e) {
	            System.out.println("StringIndexOutOfBoundsException caught: Index is out of range.");
	        }

	        sc.close();
	    }
	}
//  output:-
//	Enter an integer: 5
//	You entered: 5
//	Enter a word: hello
//	Enter an index to access character: 2
//	Character at index 2 is: l

