package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.ui.Model;

@Controller
@SessionAttributes("username")
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login"; // Should match the name of your login.jsp file
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, Model model) {
        model.addAttribute("username", username);
        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/login";
    }
}

