package wiprotraining;


		// Abstract class
		abstract class Person {
		    String name;

		    Person(String name) {
		        this.name = name;
		    }

		    // Abstract methods
		    abstract void eat();
		    abstract void exercise();
		}

		// Subclass: Athlete
		class Athlete extends Person {

		    Athlete(String name) {
		        super(name);
		    }

		    @Override
		    void eat() {
		        System.out.println(name + " eats a healthy and high-protein diet.");
		    }

		    @Override
		    void exercise() {
		        System.out.println(name + " exercises regularly with intense workouts.");
		    }
		}

		// Subclass: LazyPerson
		class LazyPerson extends Person {

		    LazyPerson(String name) {
		        super(name);
		    }

		    @Override
		    void eat() {
		        System.out.println(name + " eats junk food while watching TV.");
		    }

		    @Override
		    void exercise() {
		        System.out.println(name + " prefers sleeping over exercising.");
		    }
		}

		public class twentyone {

			public static void main(String[] args) {
		        Person athlete = new Athlete("Rahul");
		        Person lazy = new LazyPerson("Gignesh");

		        System.out.println("== Athlete ==");
		        athlete.eat();
		        athlete.exercise();

		        System.out.println("\n== Lazy Person ==");
		        lazy.eat();
		        lazy.exercise();
		    

	}

}
//		output:-
//		== Athlete ==
//				Rahul eats a healthy and high-protein diet.
//				Rahul exercises regularly with intense workouts.
//
//				== Lazy Person ==
//				Gignesh eats junk food while watching TV.
//				Gignesh prefers sleeping over exercising.
