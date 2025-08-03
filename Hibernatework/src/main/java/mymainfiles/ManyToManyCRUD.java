package mymainfiles;

import mypojos.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class ManyToManyCRUD {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("wiprohibernate.cfg.xml").buildSessionFactory();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Book & Author Menu ---");
            System.out.println("1. Add Book with Authors");
            System.out.println("2. View All Books with Authors");
            System.out.println("3. Delete Book by ID");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    Book book = new Book(title);

                    System.out.print("How many authors? ");
                    int count = sc.nextInt();
                    sc.nextLine();

                    for (int i = 1; i <= count; i++) {
                        System.out.print("Enter Author Name: ");
                        String authorName = sc.nextLine();
                        Author author = new Author(authorName);
                        book.addAuthor(author);
                    }

                    Session session = factory.openSession();
                    org.hibernate.Transaction tx = session.beginTransaction();
                    session.save(book);
                    tx.commit();
                    session.close();

                    System.out.println("Book and authors saved.");
                    break;

                case 2:
                    Session readSession = factory.openSession();
                    List<Book> books = readSession.createQuery("from Book", Book.class).list();
                    for (Book b : books) {
                        System.out.println("\nBook ID: " + b.getId() + ", Title: " + b.getTitle());
                        for (Author a : b.getAuthors()) {
                            System.out.println("   Author: " + a.getName());
                        }
                    }
                    readSession.close();
                    break;

                case 3:
                    System.out.print("Enter Book ID to delete: ");
                    int idToDelete = sc.nextInt();
                    Session delSession = factory.openSession();
                    org.hibernate.Transaction delTx = delSession.beginTransaction();
                    Book bookToDelete = delSession.get(Book.class, idToDelete);
                    if (bookToDelete != null) {
                        delSession.delete(bookToDelete);
                        System.out.println("Book deleted.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    delTx.commit();
                    delSession.close();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        factory.close();
        sc.close();
    }
}
