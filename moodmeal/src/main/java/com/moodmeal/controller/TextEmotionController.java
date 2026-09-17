package com.moodmeal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moodmeal.service.TextEmotionService;

@RestController
@RequestMapping("/api")
public class TextEmotionController {

    private final TextEmotionService emotionService;

    public TextEmotionController(TextEmotionService emotionService) {
        this.emotionService = emotionService;
    }

    // For text-based mood detection
    @GetMapping("/suggest-meal")
    public ResponseEntity<String> suggestMealFromText(@RequestParam String text) {
        String meal = emotionService.getMealByText(text);
        return ResponseEntity.ok("Suggested meal: " + meal);
    }

    // ✅ New: For face-based mood detection (used by face.html)
    @GetMapping("/meal-by-mood")
    public ResponseEntity<String> suggestMealByMood(@RequestParam String mood) {
        String meal;
        switch (mood.toLowerCase()) {
            case "happy": meal = "Ice Cream 🍦"; break;
            case "sad": meal = "Warm Soup 🍜"; break;
            case "angry": meal = "Dark Chocolate 🍫"; break;
            case "neutral": meal = "Fruit Salad 🥗"; break;
            case "fearful": meal = "Chamomile Tea ☕"; break;
            case "disgusted": meal = "Lemon Water 🍋"; break;
            case "surprised": meal = "Cupcake 🧁"; break;
            case "stressed": meal = "Herbal Tea 🍵"; break;
            default: meal = "Fresh Juice 🍹"; break;
        }

        return ResponseEntity.ok(meal);
    }
}
