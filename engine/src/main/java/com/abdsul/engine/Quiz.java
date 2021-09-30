package com.abdsul.engine;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collections;
import java.util.List;

public class Quiz {
    private long id;

    @NotBlank(message = "Title must not be blank")
    private String title;

    @NotBlank(message = "Question must not be blank")
    private String text;

    @NotNull
    @Size(min = 2)
    private List<String> options;


    private List<Integer> answer;

    public Quiz() {
    }

    public Quiz(long id, String title, String text, List<String> options, List<Integer> correctAnswer) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.options = options;
        this.answer = correctAnswer;
    }

    public long getId() {
        return id;
    }

    @JsonProperty
    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    @JsonIgnore
    @JsonProperty
    public List<Integer> getAnswer() {

        if (answer != null) {
            return answer;
        } else {
            return  Collections.emptyList();
        }

    }

    public void setAnswer(List<Integer> correctAnswer) {
       if (correctAnswer != null) {
           this.answer = correctAnswer;
       } else {
           this.answer = Collections.emptyList();
       }

    }
}
