package com.moodmeal.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MoodController{
    //@GetMapping("/api/meal")
    public String getMealSuggestion(@RequestParam String mood){
        switch (mood.toLowerCase()){
            case "happy":
            return "🍕 Pizza Party!";
            case "sad":
            return "🍫 Chocolate and Icecream";
            case "stressed":
            return "Herbal Tea and Soup";
            case "exicted":
            return "🥟 Momos";
            default:
            return "🥗 How about a healthy salad?";
        }
    } 
}