package net.springdemo.personapp;

import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import net.springdemo.personapp.dao.PersonDAO;
import net.springdemo.personapp.dao.PersonDAOImpl;

import javax.sql.DataSource;
import java.util.Properties;
import java.io.IOException;

@Configuration
@PropertySource("classpath:database.properties")
public class AppConfig {

    @Bean
    public DataSource dataSource(org.springframework.core.env.Environment env) {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        ds.setUrl(env.getProperty("jdbc.url"));
        ds.setUsername(env.getProperty("jdbc.username"));
        ds.setPassword(env.getProperty("jdbc.password"));
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource ds) {
        return new JdbcTemplate(ds);
    }

    @Bean
    public PersonDAO personDAO(JdbcTemplate jdbcTemplate) {
        return new PersonDAOImpl(jdbcTemplate);
    }
}
