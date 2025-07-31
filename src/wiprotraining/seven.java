package wiprotraining;
import java.util.Scanner;
public class seven {
	
	public static void main(String[] args) {
		Scanner Sc=new Scanner(System.in);
		System.out.println("Enter number of days held:-");
		int held=Sc.nextInt();
		System.out.println("Enter number of days attened:-");
		int attened=Sc.nextInt();
		double percentage=attened*100/held;
		
		if(percentage>70.0)
		{
			System.out.println("student is allowed to sit in exam");
			System.out.println("Your attendence is:-"+percentage);
		}
		else
		{
			System.out.println("student is Not allowed to sit in exam");
			System.out.println("Your attendence is:-"+percentage);
		}
	}

}
