package com.example.demo.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.Model.User;
import com.example.demo.Services.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;

	
	@GetMapping("")
	public String Welcome(Model model) {
		model.addAttribute("newuser", new User());
//		model.addAttribute("loguser", new User());

		return "Home";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public String checkLogin(@ModelAttribute("user") User user, HttpSession session , Model model ) {
		System.out.println("::::::::::::::::::::");
		System.out.println(user.toString());
		System.out.println("::::::::::::::::::::");
		User userlogin=loginService.checkValid(user);
		System.out.println(userlogin.toString());
		
		model.addAttribute("user", userlogin);
		session.setAttribute("userlogin",userlogin );
//		return "index";
		return "profile";
	}

}
