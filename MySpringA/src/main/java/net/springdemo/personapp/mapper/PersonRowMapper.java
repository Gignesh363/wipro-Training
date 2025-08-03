package net.springdemo.personapp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.springdemo.personapp.model.Person;
import org.springframework.jdbc.core.RowMapper;

public class PersonRowMapper implements RowMapper<Person> {
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person p = new Person();
        p.setId(rs.getInt("id"));
        p.setAge(rs.getInt("age"));
        p.setFirstName(rs.getString("first_name"));
        p.setLastName(rs.getString("last_name"));
        return p;
    }
}
