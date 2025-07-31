package wiprotraining;
import java.util.ArrayList;
import java.util.List;

public class thirtytwo {
    public static void main(String[] args) {

        // 1. NegativeArraySizeException
        try {
            int[] arr = new int[-5];
        } catch (NegativeArraySizeException e) {
            System.out.println("Caught NegativeArraySizeException");
            e.printStackTrace();
        }

        // 2. ArrayIndexOutOfBoundsException
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]); // Invalid index
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException");
            e.printStackTrace();
        }

        // 3. StringIndexOutOfBoundsException
        try {
            String str = "Java";
            System.out.println(str.charAt(10)); // Invalid index
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException");
            e.printStackTrace();
        }

        // 4. IndexOutOfBoundsException (must come after array/string exceptions)
        try {
            List<Integer> list = new ArrayList<>();
            list.add(100);
            System.out.println(list.get(5)); // Invalid index
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught IndexOutOfBoundsException");
            e.printStackTrace();
        }

        // 5. NullPointerException
        try {
            String s = null;
            System.out.println(s.length()); // Calling method on null
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException");
            e.printStackTrace();
        }

        // 6. ArithmeticException
        try {
            int x = 10 / 0; // Division by zero
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException");
            e.printStackTrace();
        }

        System.out.println("Program continues...");
    }
}
