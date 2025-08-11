package com.example.transactionlogging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransactionloggingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionloggingApplication.class, args);
	}

}
//http://localhost:8080/transaction?amount=1500