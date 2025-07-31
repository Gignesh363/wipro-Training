package wiprotraining;


	class Shape {

	    // Area of square
	    void area(int side) {
	        int result = side * side;
	        System.out.println("Area of Square: " + result);
	    }

	    // Area of rectangle
	    void area(int length, int breadth) {
	        int result = length * breadth;
	        System.out.println("Area of Rectangle: " + result);
	    }

	    // Perimeter of square
	    void perimeter(double side) {
	        double result = 4 * side;
	        System.out.println("Perimeter of Square: " + result);
	    }

	    // Perimeter of rectangle
	    void perimeter(double length, double breadth) {
	        double result = 2 * (length + breadth);
	        System.out.println("Perimeter of Rectangle: " + result);
	    }
	}
	
	public class fourteen {
	    public static void main(String[] args) {
	        Shape s = new Shape();

	        // Square calculations
	        s.area(5);             // side = 5
	        s.perimeter(5.0);      // side = 5.0

	        System.out.println();  // Just for spacing

	        // Rectangle calculations
	        s.area(4, 6);          // length = 4, breadth = 6
	        s.perimeter(4.0, 6.0); // length = 4.0, breadth = 6.0
	    }
	}

