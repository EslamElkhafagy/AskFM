package com.example.demo.Model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String contentQue; // qustion text

	@ManyToOne
	@JoinColumn(name = "sender_id")
//	@JsonBackReference
    @JsonIgnoreProperties(value="sender_questions", allowSetters=true)
	private User senderUser;
	@ManyToOne
	@JoinColumn(name = "reciver_id")
//	@JsonBackReference
    @JsonIgnoreProperties(value="reciver_questions", allowSetters=true)
	private User recUser;

	@Temporal(TemporalType.DATE)
	private Date date;
	
	private boolean visableName;

	@OneToOne(mappedBy = "question", cascade = CascadeType.ALL)
	private Answer answer;

	public User getSenderUser() {
		return senderUser;
	}

	public void setSenderUser(User senderUser) {
		this.senderUser = senderUser;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContentQue() {
		return contentQue;
	}

	public void setContentQue(String contentQue) {
		this.contentQue = contentQue;
	}

	public User getRecUser() {
		return recUser;
	}

	public void setRecUser(User recUser) {
		this.recUser = recUser;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isVisableName() {
		return visableName;
	}

	public void setVisableName(boolean visableName) {
		this.visableName = visableName;
	}

}
