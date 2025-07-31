package wiprotraining;

public class twentythree {



		    // Hall class
		    static class Hall {
		        void showMessage() {
		            // using 'System' implicitly by importing static method
		            System.out.println("This is the first room while entering the house");
		        }
		    }

		    // Kitchen class
		    static class Kitchen {
		        void showAppliances() {
		            String[] appliances = {"Fridge", "Microwave", "Oven", "Mixer"};

		            System.out.println("Appliances in Kitchen:");
		            for (String item : appliances) {
		                System.out.println(item);
		            }

		            // Copying array
		            String[] copy = new String[appliances.length];
		            for (int i = 0; i < appliances.length; i++) {
		                copy[i] = appliances[i];
		            }

		            System.out.println("\nCopied Appliances:");
		            for (String item : copy) {
		                System.out.println(item);
		            }
		        }
		    }

		    // Main method
		    public static void main(String[] args) {
		        Hall hall = new Hall();
		        hall.showMessage();

		        System.out.println();

		        Kitchen kitchen = new Kitchen();
		        kitchen.showAppliances();
		    }
		}

	
