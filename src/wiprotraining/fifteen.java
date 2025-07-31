package wiprotraining;


	import java.util.Scanner;

	public class fifteen {
		public static void main(String[] args) {
	        int[] arr = new int[10]; // Array with 10 elements
	        Scanner sc = new Scanner(System.in);

	      
	        System.out.println("Enter 10 elements:");
	        for (int i = 0; i < arr.length; i++) {
	            arr[i] = sc.nextInt();
	        }

	        
	        boolean[] visited = new boolean[10];

	        System.out.println("\nElement | Frequency");
	        System.out.println("--------------------");

	        
	        for (int i = 0; i < arr.length; i++) {
	            if (visited[i] == true)
	                continue;

	            int count = 1;

	            for (int j = i + 1; j < arr.length; j++) {
	                if (arr[i] == arr[j]) {
	                    count++;
	                    visited[j] = true; 
	                }
	            }

	            System.out.println("   " + arr[i] + "     |     " + count);
	        }

	        sc.close();
	    }
	}

