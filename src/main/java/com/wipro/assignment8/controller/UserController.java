package com.wipro.assignment8.controller;

import com.wipro.assignment8.model.User;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/enroll")
    public String showForm(Model model) {
        model.addAttribute("student", new User());
        model.addAttribute("subjectList", getSubjects());
        return "enroll";
    }

    @PostMapping("/register")
    public String submitForm(@Valid @ModelAttribute("student") User student,
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            model.addAttribute("subjectList", getSubjects());
            return "enroll";
        }
        return "enroll-success";
    }

    // ✅ JSON endpoint for Postman testing
    @PostMapping("/register-json")
    @ResponseBody
    public ResponseEntity<?> registerJson(@RequestBody @Valid User student, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        return ResponseEntity.ok("Student enrolled successfully! Welcome, " + student.getFirstName());
    }

    private List<String> getSubjects() {
        return Arrays.asList("Math", "Science", "English", "History");
    }
}
