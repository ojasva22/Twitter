package com.bhtwitter.twitter.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="likes")
public class Likes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private Integer id;
	
	@Column(name = "liked_on")
	private LocalDateTime likedOn;
	
	@ManyToOne
	@JoinColumn(name = "user_liked")
	private Users userLiked;
	
	@ManyToOne
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@JoinColumn(name="tweet_liked")
	private Tweets tweetLiked;
	
	Likes(){}

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public LocalDateTime getLikedOn() {
		return likedOn;
	}

	public void setLikedOn(LocalDateTime likedOn) {
		this.likedOn = likedOn;
	}

	public Users getUserLiked() {
		return userLiked;
	}

	public void setUserLiked(Users userLiked) {
		this.userLiked = userLiked;
	}

	public Tweets getTweetLiked() {
		return tweetLiked;
	}

	public void setTweetLiked(Tweets tweetLiked) {
		this.tweetLiked = tweetLiked;
	}

	public Likes(LocalDateTime likedOn, Users userLiked, Tweets tweetLiked) {
		
		this.likedOn = likedOn;
		this.userLiked = userLiked;
		this.tweetLiked = tweetLiked;
	}
	
}
