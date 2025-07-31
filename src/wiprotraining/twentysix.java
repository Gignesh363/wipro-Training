package wiprotraining;

public class twentysix {

	public static void main(String[] args) {
		        int[] input = {2, 3, 54, 1, 6, 7, 7};
		        int[] unique = new int[input.length];
		        int uniqueCount = 0;

		        // Remove duplicates manually
		        for (int i = 0; i < input.length; i++) {
		            boolean isDuplicate = false;
		            for (int j = 0; j < uniqueCount; j++) {
		                if (input[i] == unique[j]) {
		                    isDuplicate = true;
		                    break;
		                }
		            }
		            if (!isDuplicate) {
		                unique[uniqueCount] = input[i];
		                uniqueCount++;
		            }
		        }

		        // Sum of even numbers
		        int sum = 0;
		        for (int i = 0; i < uniqueCount; i++) {
		            if (unique[i] % 2 == 0) {
		                sum += unique[i];
		            }
		        }

		        // Print result
		        System.out.println("Sum of even numbers (after removing duplicates): " + sum);
		    }
		


	}


