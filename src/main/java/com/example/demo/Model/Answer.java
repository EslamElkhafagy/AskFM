package com.example.demo.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="answer")
public class Answer {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String contentAns;

@OneToOne(fetch=FetchType.LAZY)
@JoinColumn(name="question_id")
private Question question;

//private User user;

@OneToOne(mappedBy="answer", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
private Like like;




public Like getLike() {
	return like;
}
public void setLike(Like like) {
	this.like = like;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getContentAns() {
	return contentAns;
}
public void setContentAns(String contentAns) {
	this.contentAns = contentAns;
}

public Question getQuestion() {
	return question;
}
public void setQuestion(Question question) {
	this.question = question;
}


/*
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}


	*/
	
	
	
	
	
}
