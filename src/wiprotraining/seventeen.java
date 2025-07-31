package wiprotraining;


	// Base class
	class Vehicle {
	    String color;
	    int wheels;
	    String model;

	    // Constructor
	    Vehicle(String color, int wheels, String model) {
	        this.color = color;
	        this.wheels = wheels;
	        this.model = model;
	    }

	    // Common method for all vehicles
	    void displayDetails() {
	        System.out.println("Model: " + model);
	        System.out.println("Color: " + color);
	        System.out.println("Number of Wheels: " + wheels);
	    }
	}

	// Truck subclass
	class Truck extends Vehicle {
	    int loadCapacity;

	    Truck(String color, int wheels, String model, int loadCapacity) {
	        super(color, wheels, model);
	        this.loadCapacity = loadCapacity;
	    }

	    void showTruckInfo() {
	        System.out.println("\n--- Truck Details ---");
	        displayDetails();
	        System.out.println("Load Capacity: " + loadCapacity + " tons");
	    }
	}

	// Bus subclass
	class Bus extends Vehicle {
	    int seatingCapacity;

	    Bus(String color, int wheels, String model, int seatingCapacity) {
	        super(color, wheels, model);
	        this.seatingCapacity = seatingCapacity;
	    }

	    void showBusInfo() {
	        System.out.println("\n--- Bus Details ---");
	        displayDetails();
	        System.out.println("Seating Capacity: " + seatingCapacity + " passengers");
	    }
	}

	// Car subclass
	class Car extends Vehicle {
	    boolean isAutomatic;

	    Car(String color, int wheels, String model, boolean isAutomatic) {
	        super(color, wheels, model);
	        this.isAutomatic = isAutomatic;
	    }

	    void showCarInfo() {
	        System.out.println("\n--- Car Details ---");
	        displayDetails();
	        System.out.println("Transmission: " + (isAutomatic ? "Automatic" : "Manual"));
	    }
	}

	// Road class with main method
	public class seventeen  {
	    public static void main(String[] args) {
	        Truck truck = new Truck("Red", 6, "TATA Heavy", 15);
	        Bus bus = new Bus("Blue", 4, "Volvo AC", 50);
	        Car car = new Car("Black", 4, "Hyundai i20", true);

	        truck.showTruckInfo();
	        bus.showBusInfo();
	        car.showCarInfo();
	    }
	}


