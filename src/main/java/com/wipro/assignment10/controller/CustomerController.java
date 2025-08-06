package com.wipro.assignment10.controller;

import com.wipro.assignment10.model.Customer;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") @Valid Customer customer,
                               BindingResult result) {
        if (result.hasErrors()) {
            return "customer-form";
        }
        return "customer-success";
    }
}
