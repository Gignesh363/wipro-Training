package com.wipro.assignment13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootHibernateCrudApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootHibernateCrudApplication.class, args);
    }
}
//http://localhost:9096/api/users in postman
//Sql commands:-
////USE wiprodb;
////SHOW TABLES;
////SELECT * FROM users;
///
///postman code
//{
//    "name": "Gignesh",
//    "salary": 650000
//}
