package wiprotraining;
import java.util.Scanner;
public class Six {

	public static void main(String[] args) {
		

		 Scanner sc = new Scanner(System.in);

	        System.out.print("Enter your marks: ");
	        int marks = sc.nextInt();
	        if(marks<0 || marks>100)
	        {
	        	System.out.println("Given marks is not Valid");
	        }
	        else
	        {
	        	if(marks>=80 )
	        	{
	        		System.out.println("Grade A");
	        	}
	        	else if(marks>=79 ||marks<=60)
	        	{
	        		System.out.println("Grade B");
	        	}
	        	else if(marks>=59 ||marks<=50)
	        	{
	        		System.out.println("Grade C");
	        	}
	        	else if(marks>=49 ||marks<=45)
	        	{
	        		System.out.println("Grade D");
	        	}
	        	else if(marks>=25 ||marks<=44)
	        	{
	        		System.out.println("Grade E");
	        	}
	        }

	}

}
