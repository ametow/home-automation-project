package edu.miu.cs.najeeb.spring.eahomeautomationproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomController {
    @GetMapping("/")
    public String welcome() {
        return "Welcome to EA Home Automation Project";
    }
}
