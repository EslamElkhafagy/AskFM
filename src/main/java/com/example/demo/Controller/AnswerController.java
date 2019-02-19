package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
//import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.Model.Answer;
import com.example.demo.Repository.AnswerRepository;

@Controller
@RequestMapping("/answer")
public class AnswerController {

	// insert , delete
	
	@Autowired
	AnswerRepository answerRepository;
	
	@RequestMapping(value="/add", method = RequestMethod.POST,headers="Accept=application/json",consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json; charset=UTF-8")
	@ResponseStatus(code=HttpStatus.ACCEPTED)
	public void addAnswer(@RequestBody Answer answer) {
		
		answerRepository.save(answer);
		System.out.println("Answer Saved !");
		
		
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.DELETE)
	public void deleteAnswer(@RequestParam int id) {
		
		answerRepository.deleteById(id);
		System.out.println("Answer deleted !");

		// add column answerstate " boolean " then update this answer to false
		// code update here 
		
		
	}
	
	
	
}
