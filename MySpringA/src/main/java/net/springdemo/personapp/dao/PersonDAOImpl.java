package net.springdemo.personapp.dao;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import net.springdemo.personapp.mapper.PersonRowMapper;
import net.springdemo.personapp.model.Person;

public class PersonDAOImpl implements PersonDAO {

    private JdbcTemplate jdbcTemplate;

    public PersonDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(Person p) {
        String sql = "INSERT INTO person (id, age, first_name, last_name) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, p.getId(), p.getAge(), p.getFirstName(), p.getLastName());
    }

    public Person getById(int id) {
        String sql = "SELECT * FROM person WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new PersonRowMapper(), id);
    }

    public List<Person> listAll() {
        String sql = "SELECT * FROM person";
        return jdbcTemplate.query(sql, new PersonRowMapper());
    }

    public void update(Person p) {
        String sql = "UPDATE person SET age=?, first_name=?, last_name=? WHERE id=?";
        jdbcTemplate.update(sql, p.getAge(), p.getFirstName(), p.getLastName(), p.getId());
    }

    public void delete(int id) {
        String sql = "DELETE FROM person WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
}
