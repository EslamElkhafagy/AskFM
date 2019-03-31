package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Repository.AnswerRepository;

@SpringBootApplication
public class Application {

	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	


	
}

