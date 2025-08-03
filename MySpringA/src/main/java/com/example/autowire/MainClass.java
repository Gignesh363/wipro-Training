package com.example.autowire;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.autowire")
public class MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainClass.class);

        Freshman freshman = context.getBean(Freshman.class);
        System.out.println("AUTOWIRED ANNOTATION DEMO");
        System.out.println("Freshman Name: " + freshman.getName());
        System.out.println("Assigned Dorm Room: " + freshman.getRoom());

        context.close();
    }
}
