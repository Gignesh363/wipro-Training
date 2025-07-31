package wiprotraining;

public class twentyseven {

	
		    // Step 1: Enum for 6 types of paper currency
		    enum Currency {
		        ONE, FIVE, TEN, TWENTY, FIFTY, HUNDRED
		    }

		    public static void main(String[] args) {

		        // Step 2: Loop through enum values and print
		        System.out.println("Currency Types:");
		        for (Currency c : Currency.values()) {
		            System.out.println("- " + c);

		            // Step 3: Switch statement to describe each
		            switch (c) {
		                case ONE:
		                    System.out.println("  ₹1 - Smallest paper denomination (rare now)");
		                    break;
		                case FIVE:
		                    System.out.println("  ₹5 - Used for small purchases like tea or snacks");
		                    break;
		                case TEN:
		                    System.out.println("  ₹10 - Common for short bus fares and small items");
		                    break;
		                case TWENTY:
		                    System.out.println("  ₹20 - Useful for small groceries or auto fares");
		                    break;
		                case FIFTY:
		                    System.out.println("  ₹50 - Mid-range note used daily");
		                    break;
		                case HUNDRED:
		                    System.out.println("  ₹100 - Popular and widely accepted note");
		                    break;
		            }
		        }
		    

	}

}
