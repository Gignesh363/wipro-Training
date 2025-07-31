package wiprotraining;
import java.util.*;

public class twwl {
	

	

	    // Inner Student class
	    static class Student {
	        private static int rollCounter = 1;
	        private int rollNo;
	        private String studName;
	        private int marksInEng;
	        private int marksInMaths;
	        private int marksInScience;

	        public Student(String name, int eng, int maths, int science) {
	            this.rollNo = rollCounter++;
	            this.studName = name;
	            this.marksInEng = eng;
	            this.marksInMaths = maths;
	            this.marksInScience = science;
	        }

	        // Getters
	        public int getRollNo() {
	            return rollNo;
	        }

	        public String getStudName() {
	            return studName;
	        }

	        public int getMarksInEng() {
	            return marksInEng;
	        }

	        public int getMarksInMaths() {
	            return marksInMaths;
	        }

	        public int getMarksInScience() {
	            return marksInScience;
	        }

	        public int getTotalMarks() {
	            return marksInEng + marksInMaths + marksInScience;
	        }

	        public double getPercentage() {
	            return getTotalMarks() / 3.0;
	        }
	    }

	    // List to hold student details
	    Student[] students = new Student[8];

	    public twwl() {
	        // Adding 8 students
	        students[0] = new Student("Ravi", 85, 90, 88);
	        students[1] = new Student("Sita", 78, 95, 80);
	        students[2] = new Student("Amit", 92, 85, 89);
	        students[3] = new Student("Geeta", 88, 89, 92);
	        students[4] = new Student("Kiran", 75, 78, 70);
	        students[5] = new Student("Manoj", 80, 82, 78);
	        students[6] = new Student("Pooja", 90, 96, 94);
	        students[7] = new Student("Raj", 85, 88, 87);
	    }

	    // 1. Display roll numbers and names in roll number order
	    public void displayRollNoAndName() {
	        System.out.println("\n1. Roll No and Name:");
	        for (int i = 0; i < students.length; i++) {
	            System.out.println(students[i].getRollNo() + " - " + students[i].getStudName());
	        }
	    }

	    // 2. Student with highest percentage
	    public void displayTopperByPercentage() {
	        Student topper = students[0];

	        for (int i = 1; i < students.length; i++) {
	            if (students[i].getPercentage() > topper.getPercentage()) {
	                topper = students[i];
	            }
	        }

	        System.out.println("\n2. Topper by Percentage:");
	        System.out.println(topper.getRollNo() + " - " + topper.getStudName());
	    }

	    // 3. Highest marks in Maths
	    public void displayTopperInMaths() {
	        Student topper = students[0];

	        for (int i = 1; i < students.length; i++) {
	            if (students[i].getMarksInMaths() > topper.getMarksInMaths()) {
	                topper = students[i];
	            }
	        }

	        System.out.println("\n3. Topper in Mathematics:");
	        System.out.println(topper.getRollNo() + " - " + topper.getStudName());
	    }

	    // 4. Ascending order of (Maths + Science)
	    public void displayByMathsAndScience() {
	        System.out.println("\n4. Sorted by Maths + Science Marks:");

	        // Create a copy of the array to sort
	        Student[] sorted = Arrays.copyOf(students, students.length);

	        for (int i = 0; i < sorted.length - 1; i++) {
	            for (int j = i + 1; j < sorted.length; j++) {
	                int total1 = sorted[i].getMarksInMaths() + sorted[i].getMarksInScience();
	                int total2 = sorted[j].getMarksInMaths() + sorted[j].getMarksInScience();

	                if (total1 > total2) {
	                    Student temp = sorted[i];
	                    sorted[i] = sorted[j];
	                    sorted[j] = temp;
	                }
	            }
	        }

	        for (int i = 0; i < sorted.length; i++) {
	            System.out.println(sorted[i].getRollNo() + " - " + sorted[i].getStudName());
	        }
	    }

	    // 5. Rank list by total marks
	    public void displayRankList() {
	        System.out.println("\n5. Rank List:");

	        Student[] ranked = Arrays.copyOf(students, students.length);

	        // Sort by total marks (descending)
	        for (int i = 0; i < ranked.length - 1; i++) {
	            for (int j = i + 1; j < ranked.length; j++) {
	                if (ranked[i].getTotalMarks() < ranked[j].getTotalMarks()) {
	                    Student temp = ranked[i];
	                    ranked[i] = ranked[j];
	                    ranked[j] = temp;
	                }
	            }
	        }

	        for (int i = 0; i < ranked.length; i++) {
	            Student s = ranked[i];
	            System.out.printf("Rank %d -> Roll No: %d, Name: %s, Total: %d, Percentage: %.2f%%\n",
	                    i + 1, s.getRollNo(), s.getStudName(), s.getTotalMarks(), s.getPercentage());
	        }
	    }

	    public static void main(String[] args) {
	    	twwl std = new twwl();

	        std.displayRollNoAndName();
	        std.displayTopperByPercentage();
	        std.displayTopperInMaths();
	        std.displayByMathsAndScience();
	        std.displayRankList();
	    }
	}
