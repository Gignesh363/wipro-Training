package com.wipro.assignment20.controller;

import com.wipro.assignment20.model.Employee;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return new Employee(id, "Employee-" + id, "IT");
    }
}
