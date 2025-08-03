package mymainfiles;

import mypojos.Student_123;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentCRUDMain {
    public static void main(String[] args) {
        // Load configuration
        Configuration cfg = new Configuration();
        cfg.configure("wiprohibernate.cfg.xml");

        // Build session factory
        SessionFactory factory = cfg.buildSessionFactory();

        // Open session
        Session session = factory.openSession();

        // Begin transaction
        session.beginTransaction();

        // Create a student and save
        Student_123 student = new Student_123("Gignesh", 21);
        session.save(student);

        // Commit transaction
        session.getTransaction().commit();

        // Close session
        session.close();
        factory.close();

        System.out.println("Student saved successfully!");
    }
}
