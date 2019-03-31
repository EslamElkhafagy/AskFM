package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
//import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.Model.Answer;
import com.example.demo.Repository.AnswerRepository;
import com.example.demo.Services.AnswerService;

@Controller
@RequestMapping("/answer")
public class AnswerController {

	// insert, delete ,  
				/*
				 * url and param for all methods in Answer Controller
				 * 
				 * 						URL						method				Body            
				 * add ->      			/add					post				answer
				 * delete ->   			/delete					DELETE				param (answerId:int),param (questionId:int)
				 * 
				 * */
	
	@Autowired
	AnswerService answerService;
	
	@RequestMapping(value="/add", method = RequestMethod.POST,headers="Accept=application/json",consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code=HttpStatus.ACCEPTED)
	public void addAnswer(@RequestBody Answer answer) {
		
		answerService.addAnswer(answer,answer.getQuestion().getId());
		System.out.println("Answer Saved !");
		
		
	}
	@ResponseBody
	@RequestMapping(value="/delete", method = RequestMethod.DELETE)
	public String deleteAnswer(@RequestParam int answerId ,@RequestParam int questionId) {
		
		answerService.deleteAnswer(answerId,questionId);
		return " ay 7aga";
			
	}

	
	// for testing only , until now
	@RequestMapping(value="/getanswer/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Answer getAnswerById(@PathVariable(value="id") int id) {
		
		Answer answer =answerService.getAnswerById(id);
		
		return answer;
		
	}
	
	
	
}
