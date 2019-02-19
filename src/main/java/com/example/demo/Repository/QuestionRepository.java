package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Question;
import com.example.demo.Model.User;

public interface QuestionRepository  extends JpaRepository<Question, Integer>{

	
List<Question>	findByRecUser(User recUser);
	
	
}
