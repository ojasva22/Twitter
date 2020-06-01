package com.bhtwitter.twitter.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tagmaster")
public class TagMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name="tags")
	private String tag;
	@Column(name = "createdon")
	private LocalDateTime createdOn;
	
	@OneToMany(mappedBy = "tagId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TweetMapping> tweets = new ArrayList<>();
	
	
	public List<TweetMapping> getTweets() {
		return tweets;
	}

	public void setTweets(List<TweetMapping> tweets) {
		this.tweets = tweets;
	}

	public TagMaster(String tag, LocalDateTime createdOn) {
		
		this.tag = tag;
		this.createdOn = createdOn;
	}

	public TagMaster(){}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	
	
	
	

}
