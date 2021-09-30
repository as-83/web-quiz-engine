package com.abdsul.engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class QuizController {
    private QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/api/quizzes")
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "application/json");
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(quizService.getAllQuizzes());
    }

    @GetMapping("/api/quizzes/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable("id") long id) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "application/json");
        Quiz quiz = quizService.getQuizById(id);
        if (quiz != null){
            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body(quiz);
        }
        return ResponseEntity.status(404)
                .headers(responseHeaders)
                .body(null);
    }

    @PostMapping("/api/quizzes/{id}/solve")
    public ResponseEntity<String> checkAnswer(@PathVariable("id") long id, @RequestBody Answer answer) {

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "application/json");
        String responseAnswer = quizService.checkAnswer(answer.getAnswer(), id);
        if (responseAnswer != null) {
            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body(responseAnswer);
        }
        return ResponseEntity.status(404)
                .headers(responseHeaders)
                .body(null);
    }

    @PostMapping("api/quizzes")
    public ResponseEntity<Quiz> addQuiz(@RequestBody @Valid Quiz newQuiz) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "application/json");
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(quizService.addQuiz(newQuiz));
    }
}
