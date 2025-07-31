package wiprotraining;
import java.util.Scanner;


	
		class Bank {
		    String accNo;
		    String custName;
		    int custGender; // 1 = Male, 2 = Female
		    String custJob;
		    double curBal;

		    Bank(String accNo, String custName, int custGender, String custJob, double curBal) {
		        this.accNo = accNo;
		        this.custName = custName;
		        this.custGender = custGender;
		        this.custJob = custJob;
		        this.curBal = curBal;
		    }

		    String getGender() {
		        return (custGender == 1) ? "Male" : "Female";
		    }

		    void display() {
		        System.out.println("Account No: " + accNo);
		        System.out.println("Name: " + custName);
		        System.out.println("Gender: " + getGender());
		        System.out.println("Job: " + custJob);
		        System.out.println("Original Balance: RM " + curBal);
		    }

		    double calcBalance() {
		        return curBal;
		    }
		}

		class Saving extends Bank {
		    double savRate;

		    Saving(String accNo, String custName, int custGender, String custJob, double curBal, double savRate) {
		        super(accNo, custName, custGender, custJob, curBal);
		        this.savRate = savRate;
		    }

		    double calcBalance() {
		        return curBal + (savRate * curBal);
		    }
		}

		class Current extends Bank {
		    boolean fixedDep;
		    double curRate;

		    Current(String accNo, String custName, int custGender, String custJob, double curBal, boolean fixedDep, double curRate) {
		        super(accNo, custName, custGender, custJob, curBal);
		        this.fixedDep = fixedDep;
		        this.curRate = curRate;
		    }

		    double calcBalance() {
		        double balance = curBal + (curRate * curBal);
		        if (fixedDep) {
		            balance -= 150;
		        }
		        return balance;
		    }
		}

		public class ninteen {

			public static void main(String[] args) {
		        Scanner sc = new Scanner(System.in);

		        // Create some sample customers
		        Bank[] customers = new Bank[4];
		        customers[0] = new Saving("S001", "Ravi", 1, "Engineer", 5000, 0.05);
		        customers[1] = new Current("C001", "Sita", 2, "Manager", 8000, true, 0.03);
		        customers[2] = new Current("C002", "Gopal", 1, "Doctor", 10000, false, 0.025);
		        customers[3] = new Saving("S002", "Meena", 2, "Teacher", 3000, 0.04);

		        // Search customer by account number
		        System.out.print("Enter account number to search: ");
		        String accNoSearch = sc.nextLine();
		        boolean found = false;

		        for (Bank b : customers) {
		            if (b.accNo.equalsIgnoreCase(accNoSearch)) {
		                System.out.println("\n--- Customer Details ---");
		                b.display();
		                System.out.println("Final Balance: RM " + b.calcBalance());
		                found = true;
		                break;
		            }
		        }

		        if (!found) {
		            System.out.println("Account not found.");
		        }

		        // Count Current account holders and total balance
		        int countCurrent = 0;
		        double totalCurrentBalance = 0;
		        for (Bank b : customers) {
		            if (b instanceof Current) {
		                countCurrent++;
		                totalCurrentBalance += b.calcBalance();
		            }
		        }

		        System.out.println("\n--- Current Account Summary ---");
		        System.out.println("Total Current Account Holders: " + countCurrent);
		        System.out.println("Total Current Account Balance: RM " + totalCurrentBalance);
		    

	}

}
