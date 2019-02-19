package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.Model.Follower;
import com.example.demo.Repository.FollowerRepository;

@Controller
@RequestMapping("/friends")
public class FollowerController {

	@Autowired
	FollowerRepository followerRepository;

	@RequestMapping(value = "/follow",
			method = RequestMethod.POST,
			headers = "Accept=application/json",
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void Follow(@RequestBody Follower follower) {

		followerRepository.save(follower);

		System.out.println("Friends Connected !");

	}

	@RequestMapping(value = "/unfollow", method = RequestMethod.DELETE)
	public void unFollow(@RequestParam int id) {
		followerRepository.deleteById(id);
		System.out.println("unFollow Friends !");

	}

}
