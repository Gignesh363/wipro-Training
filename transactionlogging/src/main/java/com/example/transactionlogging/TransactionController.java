package com.example.transactionlogging;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @GetMapping("/transaction")
    public String processTransaction(@RequestParam double amount) {
        return "Transaction of Rs." + amount + " processed successfully.";
    }
}
