package com.moodmeal.service;

import org.springframework.stereotype.Service;

@Service
public class TextEmotionService {

    public String getMealByText(String text) {
        String mood = detectMood(text);

        switch (mood) {
            case "happy":
                return "🍕 Pizza Party!";
            case "sad":
                return "🍫 Chocolate and Ice Cream!";
            case "stressed":
                return "☕ Herbal Tea and Soup";
            case "excited":
                return "🍣 Sushi Time!";
            default:
                return "🥗 How about a healthy salad?";
        }
    }

    public String detectMood(String text) {
        text = text.toLowerCase();

        if (text.contains("tired") || text.contains("down") || text.contains("hopeless") || text.contains("sad") || text.contains("crying")) {
            return "sad";
        } else if (text.contains("angry") || text.contains("frustrated") || text.contains("irritated")) {
            return "stressed";
        } else if (text.contains("excited") || text.contains("joy") || text.contains("great")) {
            return "excited";
        } else if (text.contains("happy") || text.contains("calm") || text.contains("relaxed")) {
            return "happy";
        } else {
            return "neutral";
        }
    }
}
