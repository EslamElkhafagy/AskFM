package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Model.User;

@Controller
public class LoginController {

	@RequestMapping("")
	public String Welcome(User user) {
		
		
		return "Home";
	}
	
	
}
