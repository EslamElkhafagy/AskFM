package com.example.demo.Model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String userName;
	private String passWord;
	private String fullName;
	private String email;
	private String birthDay;
	private String gender;
	private String location;
	private String bio;
	private String web;
	private String hashTags;
	private byte allowAnonQuestion; // Allow anonymous questions ?
	private byte allowSharePosts; // >Allow other users to share posts ?
	private byte allowOnDiscoverFeed; // Allow showing user answers on Discover feed ?
	private byte showStatus;
	private String profileImagePath; // upload image in file and store path
	private String backgroundImagePath;

	
	/*
	 * Questions Part
	 * 
	 * */
	@OneToMany(mappedBy = "recUser", cascade = CascadeType.ALL)
//	@JsonIgnore
//	 @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonIgnoreProperties(value="recUser", allowSetters=true)
	private Set<Question> reciver_questions = new HashSet<>();
	@OneToMany(mappedBy = "senderUser", cascade = CascadeType.ALL)
//	@JsonIgnore
//	 @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonIgnoreProperties(value="senderUser", allowSetters=true)
	private Set<Question> sender_questions = new HashSet<>();
	
	
	
	/*
	 * 
	 * Friends Part
	 * 
	 * */

	@OneToMany(mappedBy = "userFollow", cascade = CascadeType.ALL)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JsonIgnore
	private Set<Follower> followers = new HashSet<>();
	@OneToMany(mappedBy = "friendFollow", cascade = CascadeType.ALL)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JsonIgnore
	private Set<Follower> friendfollowers = new HashSet<>();
	
	

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Notification> notifications = new HashSet<>();

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Answer answer;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Like like;

	
	
	
	public Set<Question> getReciver_questions() {
		return reciver_questions;
	}

	public void setReciver_questions(Set<Question> reciver_questions) {
		this.reciver_questions = reciver_questions;
	}

	public Set<Question> getSender_questions() {
		return sender_questions;
	}

	public void setSender_questions(Set<Question> sender_questions) {
		this.sender_questions = sender_questions;
	}

	public Set<Follower> getFriendfollowers() {
		return friendfollowers;
	}

	public void setFriendfollowers(Set<Follower> friendfollowers) {
		this.friendfollowers = friendfollowers;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public Like getLike() {
		return like;
	}

	public void setLike(Like like) {
		this.like = like;
	}

//	public Set<Question> getsender_questions() {
//		return sender_questions;
//	}
//
//	public void setsender_questions(Set<Question> questions) {
//		this.sender_questions = questions;
//	}

	public Set<Follower> getFollowers() {
		return followers;
	}

	public void setFollowers(Set<Follower> followers) {
		this.followers = followers;
	}

	public Set<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getHashTags() {
		return hashTags;
	}

	public void setHashTags(String hashTags) {
		this.hashTags = hashTags;
	}

	public byte getAllowAnonQuestion() {
		return allowAnonQuestion;
	}

	public void setAllowAnonQuestion(byte allowAnonQuestion) {
		this.allowAnonQuestion = allowAnonQuestion;
	}

	public byte getAllowSharePosts() {
		return allowSharePosts;
	}

	public void setAllowSharePosts(byte allowSharePosts) {
		this.allowSharePosts = allowSharePosts;
	}

	public byte getAllowOnDiscoverFeed() {
		return allowOnDiscoverFeed;
	}

	public void setAllowOnDiscoverFeed(byte allowOnDiscoverFeed) {
		this.allowOnDiscoverFeed = allowOnDiscoverFeed;
	}

	public byte getShowStatus() {
		return showStatus;
	}

	public void setShowStatus(byte showStatus) {
		this.showStatus = showStatus;
	}

	public String getProfileImagePath() {
		return profileImagePath;
	}

	public void setProfileImagePath(String profileImagePath) {
		this.profileImagePath = profileImagePath;
	}

	public String getBackgroundImagePath() {
		return backgroundImagePath;
	}

	public void setBackgroundImagePath(String backgroundImagePath) {
		this.backgroundImagePath = backgroundImagePath;
	}

}
