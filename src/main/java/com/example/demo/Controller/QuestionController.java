package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Model.Question;
import com.example.demo.Model.User;
import com.example.demo.Repository.QuestionRepository;

@Controller
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	QuestionRepository questionRepository;
	
	@RequestMapping(value="/add",method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void addQuestion(@RequestBody Question question) {
		
		questionRepository.save(question);
		
		System.out.println("Questions Saved !");
			
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	public void deleteQuestions(@RequestParam int id) {
		
		questionRepository.deleteById(id);
		System.out.println("Questions Deleted !");
	}
	
	
	
		@RequestMapping(value="/getall", method=RequestMethod.GET , produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseBody
		public List<Question> getQuestions() {
		
			List<Question> all = questionRepository.findAll();
			all.forEach(list->System.out.println(list.toString()));
			return all;
			
		}
	
	// uncompleted yet .
	@RequestMapping(value="/getquestions", method=RequestMethod.GET , produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<Question> getQuestions(@RequestParam User user) {
	
		List<Question> all = questionRepository.findByRecUser(user);
		System.out.println(all.toString());
		return all;
		
	}
	
	
	
}
