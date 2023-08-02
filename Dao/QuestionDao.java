package com.rahul.quizapp.Dao;

import com.rahul.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionDao extends JpaRepository<Question,Integer> {

    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM question q Where q.category=:category ORDER BY RANDOM() LIMIT :numQ",nativeQuery = true)
    List<Question> findRandomQuestionByCategory(String category, int numQ);
}
