package wiprotraining;
import java.util.Scanner;
public class Fourth {

	public static void main(String[] args) {
		Scanner s1=new Scanner(System.in);
		System.out.println("Enter your name");
		String name = s1.nextLine();
		System.out.println("Enter thr Roll Number");
		int num= s1.nextInt(); 
		s1.nextLine();
		System.out.println("Field of interst");
		String field=s1.nextLine();
		System.out.println("my name is"+ name+ "and my roll number is"+ num+". My field of interest are "+field);
		}

}