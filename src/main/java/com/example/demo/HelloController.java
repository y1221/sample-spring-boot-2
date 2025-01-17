package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping({ "", "/" })
    public String hello(Model model) {
        String message = "Hello Sample Spring Boot 2！";
        model.addAttribute("message", message);
        return "hello";
    }
}
