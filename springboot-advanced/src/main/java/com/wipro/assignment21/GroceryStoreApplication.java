package com.wipro.assignment21;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GroceryStoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(GroceryStoreApplication.class, args);
    }
}
//// 1. Public Access — No Login Required
//URL:
//
//bash
//Copy code
//http://localhost:9096/grocery/public
//Description:
//Accessible by everyone without login.
//
//👤 2. User Access — Requires USER Role
//URL:
//
//bash
//Copy code
//http://localhost:9096/grocery/items
//Username: user
//Password: user
//
//Description:
//Accessible only by users with the ROLE_USER role.
//
//👑 3. Admin Access — Requires ADMIN Role
//URL:
//
//bash
//Copy code
//http://localhost:9096/grocery/orders
//Username: admin
//Password: admin