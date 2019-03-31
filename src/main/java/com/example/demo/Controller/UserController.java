package com.example.demo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	// insert, delete , update, findBYID , findBYUserName, findAll
	/*
	 * url and param for all methods in user Controller
	 * 
	 * 					URL						method				Body            
	 * add ->      		/add					post				user
	 * delete ->   		/delete					DELETE				param (id:int)
	 * update ->   		/update					PUT					user , param(id:int)
	 * userBYid->  		/getuser				GET					param (id:int)
	 * userBYUserName-> /getuser/{userName}		GET					var(userName:String)
	 * allUsers ->		/allusers				GET
	 * 
	 * */

	@Autowired
	UserService userService;

	@RequestMapping(value = "/add",
			method = RequestMethod.POST/*,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE*/)
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void addUser(@RequestBody User user) {
       System.out.println(user.toString());
       
		userService.addUser(user);

		System.out.println("user Saved !");

	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	// @ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void deleteUser(@RequestParam int id) {

		userService.deleteUser(id);
		System.out.println("user deleted !");
	}

	
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void updateUser(@RequestBody User user, @RequestParam int id) {

		userService.updateUser(user, id);;
		
		System.out.println("User Updated !");
	
		

	}

	
	/*
	 *@param id to get user account data
	 * */
@RequestMapping(value="/getuser",method = RequestMethod.GET)	
@ResponseBody
	public User getUserById(@RequestParam int id) {
		
		return userService.getUserById(id);

	}

/*
 * @param username for view other user data
 * */
@RequestMapping(value="/getuser/{userName}",method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)	
public void getUserByUserName(@PathVariable(value= "userName") String userName) {
	
	System.out.println("UserName : "+userName);
	userService.getUserByUserName(userName);

}	


/*
 * this method for admin 
 * */
@RequestMapping(value="/allusers", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public void getAllUsers() {
	
userService.getAllUsers();
	
}




}
