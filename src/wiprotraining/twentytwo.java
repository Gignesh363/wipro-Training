package wiprotraining;


	interface Drawable {
	    void drawingColor();
	    void thickness();
	}

	// Fillable interface
	interface Fillable {
	    void fillingColor();
	    void size();
	}

	// Class: Line
	class Line implements Drawable {

	    @Override
	    public void drawingColor() {
	        System.out.println("Line drawing color: Black");
	    }

	    @Override
	    public void thickness() {
	        System.out.println("Line thickness: 1px");
	    }
	}

	// Class: Circle
	class Circle implements Drawable, Fillable {

	    @Override
	    public void drawingColor() {
	        System.out.println("Circle drawing color: Blue");
	    }

	    @Override
	    public void thickness() {
	        System.out.println("Circle thickness: 2px");
	    }

	    @Override
	    public void fillingColor() {
	        System.out.println("Circle filling color: Light Blue");
	    }

	    @Override
	    public void size() {
	        System.out.println("Circle size: Radius = 5");
	    }
	}

	// Class: Square
	class Square implements Drawable, Fillable {

	    @Override
	    public void drawingColor() {
	        System.out.println("Square drawing color: Green");
	    }

	    @Override
	    public void thickness() {
	        System.out.println("Square thickness: 3px");
	    }

	    @Override
	    public void fillingColor() {
	        System.out.println("Square filling color: Yellow");
	    }

	    @Override
	    public void size() {
	        System.out.println("Square size: Side = 6");
	    }
	}

	// Main class
	public class twentytwo {
	    public static void main(String[] args) {
	        System.out.println("-- Line --");
	        Line line = new Line();
	        line.drawingColor();
	        line.thickness();

	        System.out.println("\n-- Circle --");
	        Circle circle = new Circle();
	        circle.drawingColor();
	        circle.thickness();
	        circle.fillingColor();
	        circle.size();

	        System.out.println("\n-- Square --");
	        Square square = new Square();
	        square.drawingColor();
	        square.thickness();
	        square.fillingColor();
	        square.size();
	    }
	}

//output:-
//-- Line --
//Line drawing color: Black
//Line thickness: 1px
//
//-- Circle --
//Circle drawing color: Blue
//Circle thickness: 2px
//Circle filling color: Light Blue
//Circle size: Radius = 5
//
//-- Square --
//Square drawing color: Green
//Square thickness: 3px
//Square filling color: Yellow
//Square size: Side = 6
//
