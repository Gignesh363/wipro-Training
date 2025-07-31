package wiprotraining;
import java.util.*;
public class nine {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        double total = 0.0;

	        while (true) {
	            System.out.print("Enter product number (1-3) or 0 to exit: ");
	            int productNumber = sc.nextInt();

	            if (productNumber == 0) {
	                break;  // Exit the loop
	            }

	            System.out.print("Enter quantity sold: ");
	            int quantity = sc.nextInt();

	            double price = 0.0;

	            // Determine price using switch
	            switch (productNumber) {
	                case 1:
	                    price = 22.50;
	                    break;
	                case 2:
	                    price = 44.50;
	                    break;
	                case 3:
	                    price = 9.98;
	                    break;
	                default:
	                    System.out.println("Invalid product number!");
	                    continue; 
	            }

	            double subtotal = price * quantity;
	            total += subtotal;

	            System.out.printf("Product %d: ₹%.2f x %d = ₹%.2f\n", productNumber, price, quantity, subtotal);
	        }

	        System.out.printf("Total retail value of all products sold: ₹%.2f\n", total);
	        sc.close();

	}

}
