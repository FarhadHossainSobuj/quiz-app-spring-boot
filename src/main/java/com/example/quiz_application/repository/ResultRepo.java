package com.example.quiz_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.quiz_application.model.Result;

@Repository
public interface ResultRepo extends JpaRepository<Result, Integer> {

}
