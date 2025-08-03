package mymainfiles;

import mypojos.Account;
import mypojos.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class OnetoManyBidirectionalCRUD {
    public static void main(String[] args) {
        SessionFactory factory = null;
        Scanner sc = new Scanner(System.in);

        try {
            factory = new Configuration().configure("wiprohibernate.cfg.xml").buildSessionFactory();

            int choice;
            do {
                System.out.println("\n--- Account & Transaction Menu ---");
                System.out.println("1. Create Account with Transactions");
                System.out.println("2. View All Accounts & Transactions");
                System.out.println("0. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Account Holder Name: ");
                        sc.nextLine(); // Clear buffer
                        String name = sc.nextLine();

                        Account acc = new Account(name);

                        System.out.print("How many transactions? ");
                        int count = sc.nextInt();
                        sc.nextLine();

                        for (int i = 1; i <= count; i++) {
                            System.out.print("Description: ");
                            String desc = sc.nextLine();

                            System.out.print("Amount: ");
                            double amt = sc.nextDouble();
                            sc.nextLine();

                            Transaction tx = new Transaction(desc, amt);
                            acc.addTransaction(tx);
                        }

                        Session session = factory.openSession();
                        org.hibernate.Transaction txn = session.beginTransaction(); // Hibernate txn
                        session.save(acc);
                        txn.commit();
                        session.close();

                        System.out.println("✅ Account and transactions saved.");
                        break;

                    case 2:
                        Session readSession = factory.openSession();
                        List<Account> accounts = readSession.createQuery("from Account", Account.class).list();

                        for (Account a : accounts) {
                            System.out.println("\nAccount ID: " + a.getId() + ", Holder: " + a.getHolderName());

                            List<Transaction> txList = a.getTransactions();
                            for (Transaction t : txList) {
                                System.out.println("   Txn ID: " + t.getId() + ", Desc: " + t.getDescription() + ", Amount: " + t.getAmount());
                            }
                        }

                        readSession.close();
                        break;

                    case 0:
                        System.out.println("👋 Exiting...");
                        break;

                    default:
                        System.out.println("❌ Invalid choice.");
                }
            } while (choice != 0);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (factory != null) factory.close();
            sc.close();
        }
    }
}
