package wiprotraining;

import java.util.Scanner;

public class eight {

	public static void main(String[] args) {
		Scanner Sc=new Scanner(System.in);
		System.out.println("Enter number of days held:-");
		int held=Sc.nextInt();
		
		
		System.out.println("Enter number of days attened:-");
		int attened=Sc.nextInt();
		 Sc.nextLine(); 
				double percentage=attened*100/held;
				System.out.println("Do you have a medical certificate? (yes/no):");
		        String Medical = Sc.nextLine();

		if(percentage>70.0)
		{
			System.out.println("student is allowed to sit in exam");
			System.out.println("Your attendence is:-"+percentage);
		}
		else
		{
			if(Medical.equalsIgnoreCase("yes"))
			{
				System.out.println("student is allowed to sit in exam");
			}
			else
			{
				System.out.println("student is Not allowed to sit in exam");
				System.out.println("Your attendence is:-"+percentage);
			}
		}

	}

}
