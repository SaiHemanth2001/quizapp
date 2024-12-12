package com.conceptile.quizapp.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conceptile.quizapp.entity.Question;
import com.conceptile.quizapp.entity.UserSummary;
import com.conceptile.quizapp.repository.QuestionRepository;

@Service
public class QuizService {

    @Autowired
    private QuestionRepository questionRepository;

    private int totalQuestions = 0;
    private int correctAnswers = 0;
    private int incorrectAnswers = 0;

    public Question getRandomQuestion() {
        List<Question> questions = questionRepository.findAll();
        if (questions.isEmpty()) {
            throw new RuntimeException("No questions available.");
        }
        return questions.get(new Random().nextInt(questions.size()));
    }

    public boolean submitAnswer(Long questionId, String answer){
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Question not found."));
        totalQuestions++;
        if(answer.length() != 1||!"ABCD".contains(answer.toUpperCase())){
        	throw new RuntimeException("No questions available.");
        }
        
        if (question.getCorrectOption().equalsIgnoreCase(answer)) {
            correctAnswers++;
            return true;
        } else {
            incorrectAnswers++;
            return false;
        }
        
    }

    public UserSummary getUserSummary() {
        return new UserSummary(totalQuestions, correctAnswers, incorrectAnswers);
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
}
