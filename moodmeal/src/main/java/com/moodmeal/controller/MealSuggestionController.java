package com.moodmeal.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MealSuggestionController {

    @GetMapping("/meal") // ✅ This stays
    public String suggestMeal(@RequestParam String mood) {
        switch (mood.toLowerCase()) {
            case "happy": return "Ice Cream 🍦";
            case "sad": return "Chocolate Therapy 🍫";
            case "stressed": return "Green Tea 🍵";
            case "excited": return "Sizzling Brownie 🔥";
            default: return "Comfort Food 🍲";
        }
    }
}
