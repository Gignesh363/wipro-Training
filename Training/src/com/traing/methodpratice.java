package com.traing;

public class methodpratice {

	public void Methode(int a)
	{
		if(a%2==0)
		{
			System.out.println("Given number is even");
		}
		else
		{
			System.out.println("Given number is odd");
		}
	}
	public static void main(String[] args) {
//		 Check if a number is even or odd
		methodpratice t1=new methodpratice();
		t1.Methode(4);
		t1.Methode(5);

	}

}
