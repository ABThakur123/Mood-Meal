package com.moodmeal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.moodmeal.model.Feedback;
import java.util.*;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    private final List<Feedback> feedbackList = new ArrayList<>();

    @PostMapping
    public ResponseEntity<String> submitFeedback(@RequestBody Feedback feedback) {
        feedbackList.add(feedback);
        return ResponseEntity.ok("Thanks for your feedback!");
    }

    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedback() {
        return ResponseEntity.ok(feedbackList);
    }
}
