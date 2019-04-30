package com.example.demo.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.Model.User;

@Controller
public class ForwardController {

	
	@RequestMapping(value="/setting", method=RequestMethod.GET)
	public String settingForward(Model model,HttpSession session) {
	User user=	(User) session.getAttribute("userlogin");
		model.addAttribute("user", user);
		
		return "setting_profile";
	}
	
	

	@RequestMapping(value="/question", method=RequestMethod.GET)
	public void questionForward(Model model,HttpSession session,HttpServletResponse response) {
	User user=	(User) session.getAttribute("userlogin");
		model.addAttribute("user", user);
		try {
			
			response.sendRedirect("/question/getquestions?id="+user.getId());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		return "";
	}
	
	
	
}
