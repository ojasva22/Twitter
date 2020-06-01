package com.bhtwitter.twitter.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tweets")

public class Tweets{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tweet_id")
	private Integer tweetId;
	
	@NotBlank(message = "Tweet must contain 1 non-whitespace chracter")
	@Size(max = 140, message = "Tweet cannot be more than 140 characters")
	@Column(name="tweets")
	private String tweet;

	
	@Column(name="created_on")
	private LocalDateTime createdOn;
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	
	@OneToMany(mappedBy = "tweetID", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TweetMapping> tags = new ArrayList<>();
	
	Tweets(){}
	
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name="uid")
	private Users tweetUserId;
	
	
	@OneToMany(mappedBy = "tweetLiked")
	@JsonIgnore
	private List<Likes> likedBy;
	
	public List<Likes> getLikedBy() {
		return likedBy;
	}
	public void setLikedBy(List<Likes> likedBy) {
		this.likedBy = likedBy;
	}
	
	public Integer getTweetId() {
		return tweetId;
	}
	public void setTweetId(Integer tweetId) {
		this.tweetId = tweetId;
	}
	public String getTweet() {
		return tweet;
	}
	public void setTweet(String tweet) {
		this.tweet = tweet;
	}
	
	
	public Users getTweetUserId() {
		return tweetUserId;
	}
	public void setTweetUserId(Users tweetUserId) {
		this.tweetUserId = tweetUserId;
	}
	
	public void addTag(TagMaster tag) {
		TweetMapping tweetMapping = new TweetMapping( LocalDateTime.now(), this, tag);
		tags.add(tweetMapping);
		tag.getTweets().add(tweetMapping);
	}

	
	
}
