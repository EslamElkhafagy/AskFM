package com.example.demo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	
	// insert, delete , update

	@Autowired
	UserRepository userRepository;

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	// @ResponseBody
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void addUser(@RequestBody User user) {

		userRepository.save(user);

		System.out.println("user Saved !");

	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	// @ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void deleteuser(@RequestParam int id) {

		userRepository.deleteById(id);
		System.out.println("user deleted !");
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void updateuser(@RequestBody User user, @RequestParam int id) {

		Optional<User> a = userRepository.findById(id);
		User upUser = a.get();
		upUser.setAllowAnonQuestion(user.getAllowAnonQuestion());
		upUser.setAllowOnDiscoverFeed(user.getAllowOnDiscoverFeed());
		upUser.setAllowSharePosts(user.getAllowSharePosts());
		upUser.setBackgroundImagePath(user.getBackgroundImagePath());
		upUser.setBio(user.getBio());
		upUser.setBirthDay(user.getBirthDay());
		upUser.setEmail(user.getEmail());
		upUser.setFullName(user.getFullName());
		upUser.setGender(user.getGender());
		upUser.setHashTags(upUser.getHashTags());
		upUser.setLocation(user.getLocation());
		upUser.setPassWord(user.getPassWord());
		upUser.setProfileImagePath(user.getProfileImagePath());
		upUser.setShowStatus(user.getShowStatus());
		upUser.setUserName(user.getUserName());
		upUser.setWeb(user.getWeb());
		userRepository.save(upUser);
		
		System.out.println("User Updated !");
		
		

	}

}
