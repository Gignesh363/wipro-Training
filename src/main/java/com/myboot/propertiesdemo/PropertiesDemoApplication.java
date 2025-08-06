package com.myboot.propertiesdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PropertiesDemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(PropertiesDemoApplication.class, args);
        ValueReader reader = context.getBean(ValueReader.class);
        reader.displayValues();
    }
}
