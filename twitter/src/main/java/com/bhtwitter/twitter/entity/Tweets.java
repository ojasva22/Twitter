package com.bhtwitter.twitter.entity;

import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vladmihalcea.hibernate.type.array.StringArrayType;

@Entity
@Table(name="tweets")
@TypeDefs({
    @TypeDef(
        name = "string-array", 
        typeClass = StringArrayType.class)})

public class Tweets{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tweet_id")
	private int tweetId;
	
	
	@Column(name="tweets")
	private String tweet;
	@Type(type = "string-array")
	@Column(name="tags")
	private String[] tags;
	@Column(name="created_on")
	private LocalDateTime createdOn;
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	Tweets(){}
	@ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name="uid")
	private Users tweetUserId;
	
	

	
	public int getTweetId() {
		return tweetId;
	}
	public void setTweetId(int tweetId) {
		this.tweetId = tweetId;
	}
	public String getTweet() {
		return tweet;
	}
	public void setTweet(String tweet) {
		this.tweet = tweet;
	}
	public String[] getTags() {
		return tags;
	}
	public void setTags(String[] tags) {
		this.tags = tags;
	}
	public Users getTweetUserId() {
		return tweetUserId;
	}
	public void setTweetUserId(Users tweetUserId) {
		this.tweetUserId = tweetUserId;
	}
	public Tweets(String tweet, String[] tags, Users tweetUserId, LocalDateTime createdOn) {

		this.tweet = tweet;
		this.tags = tags;
		this.tweetUserId = tweetUserId;
		this.createdOn = createdOn;
	}
	
	
	
}
