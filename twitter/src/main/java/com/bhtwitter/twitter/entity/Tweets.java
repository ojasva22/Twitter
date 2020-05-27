package com.bhtwitter.twitter.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.array.ListArrayType;

@Entity
@Table(name="tweets")
@TypeDefs({
    @TypeDef(
        name = "list-array", 
        typeClass = ListArrayType.class)})
public class Tweets{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tweet_id")
	private int tweetId;
	
	
	
	@Column(name="tweets")
	private String tweet;

	@Type(type = "list-array")
	@Column(name="tags")
	private List<String> tags;
	
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
	
	
	@OneToMany(mappedBy = "tweetLiked")
	@JsonIgnore
	private List<Likes> likedBy;
	
	public List<Likes> getLikedBy() {
		return likedBy;
	}
	public void setLikedBy(List<Likes> likedBy) {
		this.likedBy = likedBy;
	}
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
	
	
	public Users getTweetUserId() {
		return tweetUserId;
	}
	public void setTweetUserId(Users tweetUserId) {
		this.tweetUserId = tweetUserId;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public Tweets(String tweet, List<String> tags, LocalDateTime createdOn, Users tweetUserId) {
		super();
		this.tweet = tweet;
		this.tags = tags;
		this.createdOn = createdOn;
		this.tweetUserId = tweetUserId;
	}
	
	
	
	
	
}
