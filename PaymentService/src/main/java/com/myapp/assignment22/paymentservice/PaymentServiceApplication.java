package com.myapp.assignment22.paymentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceApplication.class, args);
	}

}
//1)first run zipkin-> cmd -> java -jar zipkin-server-3.5.1-exec.jar in commandPrompt
//2)http://localhost:8082/payment-->2 run this payment application
// 3)run order server application