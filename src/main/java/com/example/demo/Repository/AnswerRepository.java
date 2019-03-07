package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Model.Answer;

public interface AnswerRepository extends JpaRepository<Answer,Integer> {
	@Modifying
	  @Query(value = "delete FROM answer WHERE id =?", nativeQuery = true)
	void deleteById(int id);
	
	
}
