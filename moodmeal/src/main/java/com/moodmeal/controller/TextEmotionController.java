package com.moodmeal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moodmeal.service.TextEmotionService;
import java.util.*;

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

    // New: For face-based mood detection (used by face.html)
    private final Map<String, List<String>> mealOptions = Map.of(
        "happy", List.of("Ice Cream 🍦", "Pizza Party 🍕", "Fruit Bowl 🍓", "Milkshake 🥤"),
        "sad", List.of("Chocolate Therapy 🍫", "Warm Soup 🍲", "Mac and Cheese 🧀", "Hot Cocoa ☕"),
        "angry", List.of("Dark Chocolate 🍫", "Spicy Noodles 🌶️", "Cold Lemonade 🍋"),
        "neutral", List.of("Fruit Salad 🥗", "Sandwich 🥪", "Yogurt Bowl 🍨"),
        "fearful", List.of("Chamomile Tea 🍵", "Warm Milk 🥛", "Comfort Soup 🍲"),
        "disgusted", List.of("Lemon Water 🍋", "Fresh Juice 🧃", "Mint Tea 🍃"),
        "surprised", List.of("Cupcake 🧁", "Popcorn 🍿", "Fruit Punch 🍹"),
        "stressed", List.of("Green Tea 🍵", "Herbal Tea and Soup 🍵", "Warm Oats 🥣")
    );

    @GetMapping("/meal-by-mood")
    public ResponseEntity<String> suggestMealByMood(@RequestParam String mood) {
        List<String> options = mealOptions.getOrDefault(mood.toLowerCase(), List.of("Comfort Food 🍜"));
        String meal = options.get(new Random().nextInt(options.size()));
        return ResponseEntity.ok(meal);
    }
}
