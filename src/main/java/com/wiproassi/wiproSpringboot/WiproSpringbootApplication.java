package com.wiproassi.wiproSpringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.wipro"})  // ✅ Updated
public class WiproSpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(WiproSpringbootApplication.class, args);
    }
}
// 3.http://localhost:9094/register
//4.http://localhost:9096/user/101/accounts?type=current&status=active
//5.