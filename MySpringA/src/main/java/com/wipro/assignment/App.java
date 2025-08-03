package com.wipro.assignment;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.wipro.assignment")
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);

        ProjectData_Properties pdp = context.getBean(ProjectData_Properties.class);
        pdp.displayData();

        context.close();
    }
}
