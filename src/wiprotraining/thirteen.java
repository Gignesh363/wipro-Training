package wiprotraining;


	class Worker {
	    String name;
	    double salaryRate;

	    // Constructor
	    Worker(String workerName, double rate) {
	        name = workerName;
	        salaryRate = rate;
	    }

	    // Pay method (can be reused)
	    double computePay(int hours) {
	        return hours * salaryRate;
	    }
	}

	// DailyWorker class - inherits from Worker
	class DailyWorker extends Worker {
	    // Constructor
	    DailyWorker(String workerName, double rate) {
	        super(workerName, rate);
	    }

	    // Method to calculate pay based on actual hours
	    double pay(int hours) {
	        return computePay(hours);  // Daily workers get paid for actual hours
	    }
	}

	// SalariedWorker class - inherits from Worker
	class SalariedWorker extends Worker {
	    // Constructor
	    SalariedWorker(String workerName, double rate) {
	        super(workerName, rate);
	    }

	    // Method to calculate pay (always for 40 hours)
	    double pay(int hours) {
	        return computePay(40);  // Always paid for 40 hours
	    }
	}

	// Main class to test
	public class thirteen {
	    public static void main(String[] args) {
	        // Create objects
	        DailyWorker d = new DailyWorker("Ravi", 100);       // ₹100 per hour
	        SalariedWorker s = new SalariedWorker("Sita", 120); // ₹120 per hour

	        // Display DailyWorker pay
	        System.out.println("Daily Worker: " + d.name);
	        System.out.println("Hours worked: 35");
	        System.out.println("Pay: ₹" + d.pay(35));
	        System.out.println();

	        // Display SalariedWorker pay
	        System.out.println("Salaried Worker: " + s.name);
	        System.out.println("Hours worked: 50");
	        System.out.println("Pay: ₹" + s.pay(50));
	    }
	}

