package com.conceptile.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conceptile.quizapp.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
