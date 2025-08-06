package com.wipro.assignment4;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class AccountController {

    @GetMapping("/user/{id}/accounts")
    public List<Account> getAccounts(
            @PathVariable String id,
            @RequestParam String type,
            @RequestParam String status) {

        Account acc = new Account(id, type, status);
        return Arrays.asList(acc);
    }
}
