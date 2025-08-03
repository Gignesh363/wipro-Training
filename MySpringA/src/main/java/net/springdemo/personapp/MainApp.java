package net.springdemo.personapp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import net.springdemo.personapp.dao.PersonDAO;
import net.springdemo.personapp.model.Person;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PersonDAO dao = context.getBean(PersonDAO.class);

        System.out.println("Creating person:");
        dao.create(new Person(4, 36, "Sergey", "Emets"));

        System.out.println("List of persons:");
        List<Person> persons = dao.listAll();
        for (Person p : persons) {
            System.out.println(p);
        }

        System.out.println("Deleting person with ID 2");
        dao.delete(2);

        System.out.println("Update person with ID 4");
        Person updated = new Person(4, 36, "Sergey", "CHANGED");
        dao.update(updated);

        System.out.println("Final list of persons:");
        persons = dao.listAll();
        for (Person p : persons) {
            System.out.println(p);
        }

        context.close();
    }
}
