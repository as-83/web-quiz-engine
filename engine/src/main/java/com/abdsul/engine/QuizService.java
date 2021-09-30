package com.abdsul.engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    private QuizRepo quizRepo;

    @Autowired
    public QuizService(QuizRepo quizRepo) {
        this.quizRepo = quizRepo;
    }

    public List<Quiz> getAllQuizzes() {
        return quizRepo.getAllQuizzes();
    }

    public String checkAnswer(List<Integer> answers, long id) {
        Quiz quiz = quizRepo.getQuizById(id);

        if (quiz != null){
            if (quiz.getAnswer().equals(answers)) {
                return "{\"success\":true,\"feedback\":\"Congratulations, you're right!\"}";
            } else {
                return "{\"success\":false,\"feedback\":\"Wrong answer! Please, try again.\"}";
            }
        } else {
            return  null;
        }

    }

    public Quiz addQuiz(Quiz newQuiz) {
        return quizRepo.addQuiz(newQuiz);
    }

    public Quiz getQuizById(long id) {
        return quizRepo.getQuizById(id);
    }
}
