package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="follower")
public class Follower {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	
//	private User user;
	
	@ManyToOne
//	@JoinColumns({@JoinColumn(name="ownerUser_id",referencedColumnName="id"),@JoinColumn(name="friendUser_id",referencedColumnName="id")})
	private User userFollow;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/*
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}*/
	public User getUserFollow() {
		return userFollow;
	}
	public void setUserFollow(User userFollow) {
		this.userFollow = userFollow;
	}
	
	
	
	
}
