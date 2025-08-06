package com.wipro.assignment6;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CssJsController {

    @GetMapping("/home")
    public String homePage() {
        return "index";
    }
}
