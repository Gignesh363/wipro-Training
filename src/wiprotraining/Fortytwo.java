package wiprotraining;

public class Fortytwo {

    // Method that initially throws an exception
    public static void someMethod2() throws Exception {
        throw new Exception("Exception thrown from someMethod2");
    }

    // Method that catches and rethrows the exception
    public static void someMethod() throws Exception {
        try {
            someMethod2(); // Call the method that throws
        } catch (Exception e) {
            System.out.println("Caught in someMethod: " + e.getMessage());
            throw e; // Rethrow the exception
        }
    }

    // Main method that catches the rethrown exception and prints the stack trace
    public static void main(String[] args) {
        try {
            someMethod(); // Call the intermediate method
        } catch (Exception e) {
            System.out.println("Caught in main:");
            e.printStackTrace(); // Print full stack trace
        }
    }
}
//output:-
//Caught in someMethod: Exception thrown from someMethod2
//Caught in main:
//java.lang.Exception: Exception thrown from someMethod2
//	at wiprotraining/wiprotraining.Fortytwo.someMethod2(Fortytwo.java:7)
//	at wiprotraining/wiprotraining.Fortytwo.someMethod(Fortytwo.java:13)
//	at wiprotraining/wiprotraining.Fortytwo.main(Fortytwo.java:23)
