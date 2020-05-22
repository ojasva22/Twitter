package com.bhtwitter.twitter.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name="users")
public class Users{
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer id;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="email")
	private String email;

	
	@Column(name="created_on")
	private LocalDateTime createdOn;
	/*
	@Column(name="user_type_id")
	private Integer userTypeId;
	*/
	
	@OneToOne(cascade = CascadeType.ALL,  orphanRemoval = true)
	@JoinColumn(name="user_type_id", referencedColumnName = "id")
	private UserType userType;
	
	Users(){}
	
	
	@OneToMany(mappedBy = "tweetUserId", cascade = CascadeType.ALL)
	private List<Tweets> twts;
	
	
	public List<Tweets> getTwts() {
		return twts;
	}



	public void setTwts(List<Tweets> twts) {
		this.twts = twts;
	}



	public UserType getUserType() {
		return userType;
	}



	public void setUserType(UserType userType) {
		this.userType = userType;
	}



	private Users(String username, String password, String email, LocalDateTime createdOn) {
		
		this.username = username;
		this.password = password;
		this.email = email;
		this.createdOn = createdOn;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	/*

	public Integer getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(Integer userTypeId) {
		this.userTypeId = userTypeId;
	}	
	*/
}


