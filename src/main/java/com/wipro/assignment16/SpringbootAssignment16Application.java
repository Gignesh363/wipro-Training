package com.wipro.assignment16;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootAssignment16Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAssignment16Application.class, args);
    }
}
//GET all posts
//Copy code
//GET http://localhost:9096/api/posts 
//GET single post
//Copy code
//GET http://localhost:9096/api/posts/1
//POST create post

//Copy code
//POST http://localhost:9096/api/posts
//Content-Type: application/json
//
//{
//    "userId": 1,
//    "title": "My New Post",
//    "body": "This is post content"
//}