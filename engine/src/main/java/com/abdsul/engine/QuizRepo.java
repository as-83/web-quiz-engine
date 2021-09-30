package com.abdsul.engine;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class QuizRepo {
    private Quiz quiz = new Quiz(1, "The Java Logo", "What is depicted on the Java logo?",
            List.of("Robot","Tea leaf","Cup of coffee","Bug"), List.of(2));
    List<Quiz> quizzes = new ArrayList<>();

    public List<Quiz> getAllQuizzes() {
        return quizzes;
    }

    public List<Integer> getCorrectAnswers(long id) {
        return quizzes.get((int)id - 1).getAnswer();
    }

    public Quiz addQuiz(Quiz newQuiz) {
        newQuiz.setId(quizzes.size() + 1);
        quizzes.add(newQuiz);
        return quizzes.get(quizzes.size() - 1);
    }

    public Quiz getQuizById(long id) {
        if (id <= quizzes.size()) {
            return quizzes.get((int)id - 1);
        } else {
            return null;
        }



    }
}
