package com.myapp.assignment7.controller;

import com.myapp.assignment7.model.Student;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
public class EnrollmentController {

    @GetMapping("/enroll")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("subjectList", Arrays.asList("Java", "Python", "Spring", "React"));
        return "enroll";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("student") Student student,
                           BindingResult result,
                           Model model) {
        if (result.hasErrors()) {
            model.addAttribute("subjectList", Arrays.asList("Java", "Python", "Spring", "React"));
            return "enroll";
        }
        return "success";
    }
}
