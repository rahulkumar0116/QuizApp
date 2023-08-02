package com.rahul.quizapp.service;

import com.rahul.quizapp.Dao.QuestionDao;
import com.rahul.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity <String> addQuestion(Question question) {
        questionDao.save(question);
        return new ResponseEntity <>("Success",HttpStatus.CREATED);
    }

    public ResponseEntity <List<Question>> getAllQuestion() {
        try {
            return new ResponseEntity<>( questionDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
      return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity <List<Question>> getQuestionByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
      return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity <String> deletebyid(Integer id) {
       questionDao.deleteById(id);
       return new ResponseEntity<>("Deleted Successfully",HttpStatus.MOVED_PERMANENTLY);
    }
}
