package com.bhtwitter.twitter.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table(name="users", uniqueConstraints = {@UniqueConstraint(columnNames = {"username", "email"})})
public class Users{
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer id;
	
	@NotBlank(message = "Username cannot be empty")
	@Size(min = 3, max = 50, message = "Username length should be between 2 and 50")
	
	@Column(name="username", unique = true)

	private String username;
	
	@NotEmpty(message = "Password cannot be Empty")
	@Size(min=6, message = "Password length should be >= 6")	
	@Column(name="password")
	private String password;
	
	@Email(message = "Invalid email")
	@Column(name="email")
	private String email;

	
	@Column(name="created_on")
	private LocalDateTime createdOn;
	@JsonProperty(access = Access.WRITE_ONLY)
	@Transient
	private String role;
	
	
	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}


	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="user_type_id", referencedColumnName = "id")
	private UserType userType;
	
	Users(){}
	
	
	@OneToMany(mappedBy = "tweetUserId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Tweets> tweets;
	@OneToMany(mappedBy = "userToFollow", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Followers> followers;
	@OneToMany(mappedBy = "userFollower", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Followers> following;
	
	@OneToMany(mappedBy = "userLiked")
	@JsonIgnore
	private List<Likes> likedTweets;
	
	
	public List<Followers> getFollowing() {
		return following;
	}



	public void setFollowing(List<Followers> following) {
		this.following = following;
	}



	public List<Likes> getLikedTweets() {
		return likedTweets;
	}



	public void setLikedTweets(List<Likes> likedTweets) {
		this.likedTweets = likedTweets;
	}



	public List<Followers> getFollowers() {
		return followers;
	}



	public void setFollowers(List<Followers> followers) {
		this.followers = followers;
	}



	public List<Tweets> getTweets() {
		return tweets;
	}



	public void setTweets(List<Tweets> tweets) {
		this.tweets = tweets;
	}



	public UserType getUserType() {
		return userType;
	}



	public void setUserType(UserType userType) {
		this.userType = userType;
	}



	public Users(String username, String password, String email, LocalDateTime createdOn) {
		
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


