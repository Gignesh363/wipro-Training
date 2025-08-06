package com.wipro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

    @GetMapping("/register")
    public String showForm() {
        return "register"; // Make sure register.html exists!
    }

    @PostMapping("/register")
    public String handleForm(
        @RequestParam String username,
        @RequestParam String password,
        @RequestParam String email,
        @RequestParam String birthday,
        @RequestParam String profession,
        Model model) {

        model.addAttribute("username", username);
        model.addAttribute("password", password);
        model.addAttribute("email", email);
        model.addAttribute("birthday", birthday);
        model.addAttribute("profession", profession);

        return "result";
    }
}
