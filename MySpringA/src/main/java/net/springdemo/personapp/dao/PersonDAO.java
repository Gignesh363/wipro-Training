package net.springdemo.personapp.dao;

import java.util.List;
import net.springdemo.personapp.model.Person;

public interface PersonDAO {
    void create(Person p);
    Person getById(int id);
    List<Person> listAll();
    void update(Person p);
    void delete(int id);
}

