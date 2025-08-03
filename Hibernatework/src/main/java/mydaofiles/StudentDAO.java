package mydaofiles;

import org.hibernate.Session;
import org.hibernate.Transaction;
import mypojos.Student_123;

public class StudentDAO {
    public void saveStudent(Session session, Student_123 student) {
        Transaction tx = session.beginTransaction();
        session.save(student);
        tx.commit();
    }
}
