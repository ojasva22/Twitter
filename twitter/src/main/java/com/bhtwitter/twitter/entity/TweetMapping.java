package com.bhtwitter.twitter.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tweetmapping")
public class TweetMapping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "createdon")
	private LocalDateTime createdOn;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tweetid")
	private Tweets tweetID;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tagid")
	private TagMaster tagId;
	
	public TweetMapping(){}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	
	public TagMaster getTagId() {
		return tagId;
	}
	public void setTagId(TagMaster tagId) {
		this.tagId = tagId;
	}

	
	public Tweets getTweetID() {
		return tweetID;
	}

	public void setTweetID(Tweets tweetID) {
		this.tweetID = tweetID;
	}

	public TweetMapping(LocalDateTime createdOn, Tweets tweetID, TagMaster tagId) {
		super();
		this.createdOn = createdOn;
		this.tweetID = tweetID;
		this.tagId = tagId;
	}

	
	
}
