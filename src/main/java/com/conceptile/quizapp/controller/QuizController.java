package com.conceptile.quizapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.conceptile.quizapp.entity.Question;
import com.conceptile.quizapp.entity.UserSummary;
import com.conceptile.quizapp.service.QuizService;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/question")
    public ResponseEntity<Question> getRandomQuestion() {
        Question question = quizService.getRandomQuestion();
        return ResponseEntity.ok(question);
    }

    @PostMapping("/answer")
    public ResponseEntity<String> submitAnswer(@RequestParam Long questionId, @RequestParam String answer){
        boolean isCorrect = quizService.submitAnswer(questionId, answer);
        return ResponseEntity.ok(isCorrect ? "Correct answer!" : "Incorrect answer!");
    }

    @GetMapping("/summary")
    public ResponseEntity<UserSummary> getQuizSummary() {
        UserSummary summary = quizService.getUserSummary();
        return ResponseEntity.ok(summary);
    }

    @GetMapping("/questions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = quizService.getAllQuestions();
        return ResponseEntity.ok(questions);
    }
}
