package wiprotraining;
	
		interface PerformOperation {
		    boolean check(int a);
		}

		public class twentyeight {

		    // 1. Lambda to check if number is odd
		    public static PerformOperation isOdd() {
		        return (a) -> a % 2 != 0;
		    }

		    // 2. Lambda to check if number is prime
		    public static PerformOperation isPrime() {
		        return (a) -> {
		            if (a <= 1) return false;
		            for (int i = 2; i <= Math.sqrt(a); i++) {
		                if (a % i == 0) return false;
		            }
		            return true;
		        };
		    }

		    // 3. Lambda to check if number is a palindrome
		    public static PerformOperation isPalindrome() {
		        return (a) -> {
		            int original = a, reversed = 0;
		            while (a != 0) {
		                int digit = a % 10;
		                reversed = reversed * 10 + digit;
		                a /= 10;
		            }
		            return original == reversed;
		        };
		    }

		    // Main method to test
		    public static void main(String[] args) {
		        PerformOperation op1 = isOdd();
		        PerformOperation op2 = isPrime();
		        PerformOperation op3 = isPalindrome();

		        int num1 = 7;
		        int num2 = 11;
		        int num3 = 121;

		        System.out.println(num1 + " is odd? " + op1.check(num1));           // true
		        System.out.println(num2 + " is prime? " + op2.check(num2));         // true
		        System.out.println(num3 + " is palindrome? " + op3.check(num3));    // true
		    }
		


	}


