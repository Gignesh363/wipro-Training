package wiprotraining;



	
		// Simulating package: org.animals
		class Lion {
		    String color = "Golden";
		    int weight = 190;
		    int age = 8;

		    boolean isVegetarian() {
		        return false;
		    }

		    boolean canClimb() {
		        return false;
		    }

		    String sound() {
		        return "Roar";
		    }
		}

		class Tiger {
		    String color = "Orange with black stripes";
		    int weight = 220;
		    int age = 7;

		    boolean isVegetarian() {
		        return false;
		    }

		    boolean canClimb() {
		        return true;
		    }

		    String sound() {
		        return "Growl";
		    }
		}

		class Deer {
		    String color = "Brown";
		    int weight = 90;
		    int age = 4;

		    boolean isVegetarian() {
		        return true;
		    }

		    boolean canClimb() {
		        return false;
		    }

		    String sound() {
		        return "Bleat";
		    }
		}

		class Monkey {
		    String color = "Brown";
		    int weight = 40;
		    int age = 5;

		    boolean isVegetarian() {
		        return true;
		    }

		    boolean canClimb() {
		        return true;
		    }

		    String sound() {
		        return "Chatter";
		    }
		}

		class Elephant {
		    String color = "Grey";
		    int weight = 5000;
		    int age = 25;

		    boolean isVegetarian() {
		        return true;
		    }

		    boolean canClimb() {
		        return false;
		    }

		    String sound() {
		        return "Trumpet";
		    }
		}

		class Giraffe {
		    String color = "Yellow with brown spots";
		    int weight = 800;
		    int age = 15;

		    boolean isVegetarian() {
		        return true;
		    }

		    boolean canClimb() {
		        return false;
		    }

		    String sound() {
		        return "Hum";
		    }
		}

		
		public class Eighteen {
		    public static void main(String[] args) {
		        Lion lion = new Lion();
		        Tiger tiger = new Tiger();
		        Deer deer = new Deer();
		        Monkey monkey = new Monkey();
		        Elephant elephant = new Elephant();
		        Giraffe giraffe = new Giraffe();

		        printDetails("Lion", lion.color, lion.weight, lion.age, lion.isVegetarian(), lion.canClimb(), lion.sound());
		        printDetails("Tiger", tiger.color, tiger.weight, tiger.age, tiger.isVegetarian(), tiger.canClimb(), tiger.sound());
		        printDetails("Deer", deer.color, deer.weight, deer.age, deer.isVegetarian(), deer.canClimb(), deer.sound());
		        printDetails("Monkey", monkey.color, monkey.weight, monkey.age, monkey.isVegetarian(), monkey.canClimb(), monkey.sound());
		        printDetails("Elephant", elephant.color, elephant.weight, elephant.age, elephant.isVegetarian(), elephant.canClimb(), elephant.sound());
		        printDetails("Giraffe", giraffe.color, giraffe.weight, giraffe.age, giraffe.isVegetarian(), giraffe.canClimb(), giraffe.sound());
		    }

		    public static void printDetails(String name, String color, int weight, int age, boolean isVeg, boolean canClimb, String sound) {
		        System.out.println("===== " + name + " =====");
		        System.out.println("Color: " + color);
		        System.out.println("Weight: " + weight + " kg");
		        System.out.println("Age: " + age + " years");
		        System.out.println("Vegetarian: " + isVeg);
		        System.out.println("Can Climb: " + canClimb);
		        System.out.println("Sound: " + sound);
		        System.out.println();
		    


	}

}
//		output
//		===== Lion =====
//				Color: Golden
//				Weight: 190 kg
//				Age: 8 years
//				Vegetarian: false
//				Can Climb: false
//				Sound: Roar
//
//				===== Tiger =====
//				Color: Orange with black stripes
//				Weight: 220 kg
//				Age: 7 years
//				Vegetarian: false
//				Can Climb: true
//				Sound: Growl
//
//				===== Deer =====
//				Color: Brown
//				Weight: 90 kg
//				Age: 4 years
//				Vegetarian: true
//				Can Climb: false
//				Sound: Bleat
//
//				===== Monkey =====
//				Color: Brown
//				Weight: 40 kg
//				Age: 5 years
//				Vegetarian: true
//				Can Climb: true
//				Sound: Chatter
//
//				===== Elephant =====
//				Color: Grey
//				Weight: 5000 kg
//				Age: 25 years
//				Vegetarian: true
//				Can Climb: false
//				Sound: Trumpet
//
//				===== Giraffe =====
//				Color: Yellow with brown spots
//				Weight: 800 kg
//				Age: 15 years
//				Vegetarian: true
//				Can Climb: false
//				Sound: Hum


