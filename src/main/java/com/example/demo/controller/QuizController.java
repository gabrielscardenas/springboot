package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes({"username", "hasTakenQuiz", "grades"})
public class QuizController {

    @GetMapping("/home")
    public String home(Model model) {
        if (!model.containsAttribute("username")) {
            return "redirect:/login";
        }

        Boolean hasTakenQuiz = (Boolean) model.getAttribute("hasTakenQuiz");
        if (hasTakenQuiz == null) {
            hasTakenQuiz = false;
            model.addAttribute("hasTakenQuiz", hasTakenQuiz);
        }

        String quizLinkLabel = hasTakenQuiz ? "Retake Quiz" : "Take Quiz";
        model.addAttribute("quizLinkLabel", quizLinkLabel);
        return "home"; // Should match the name of your home.jsp file
    }

    @GetMapping("/quiz")
    public String quiz(Model model) {
        if (!model.containsAttribute("username")) {
            return "redirect:/login";
        }
        return "quiz"; // Should match the name of your quiz.jsp file
    }

    @PostMapping("/quiz")
    public String submitQuiz(@RequestParam("score") int score, Model model) {
        String username = (String) model.getAttribute("username");
        model.addAttribute("hasTakenQuiz", true);

        Map<String, Integer> grades = (Map<String, Integer>) model.getAttribute("grades");
        if (grades == null) {
            grades = new HashMap<>();
        }
        grades.put(username, score);
        model.addAttribute("grades", grades);

        return "redirect:/grades";
    }

    @GetMapping("/grades")
    public String grades(Model model) {
        if (!model.containsAttribute("username")) {
            return "redirect:/login";
        }
        return "grades"; // Should match the name of your grades.jsp file
    }
}
