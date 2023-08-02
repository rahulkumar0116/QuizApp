package com.rahul.quizapp.controller;

import com.rahul.quizapp.model.Question;
import com.rahul.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public ResponseEntity< List<Question>> getAllQuestion(){
       return questionService.getAllQuestion();
    }
@GetMapping("category/{category}")
    public ResponseEntity <List<Question>> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }
    @PostMapping("add")
    public ResponseEntity <String> addQuestion(@RequestBody Question question){
      return questionService.addQuestion(question);

    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Integer id){
        return questionService.deletebyid(id);

    }
    
}
