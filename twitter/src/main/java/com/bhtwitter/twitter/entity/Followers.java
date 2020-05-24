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

@Entity
@Table(name="followers")
public class Followers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@ManyToOne
	@JoinColumn(name="follower_id")
	private Users userFollower;
	@ManyToOne
	@JoinColumn(name="following_id")
	private Users userToFollow;
	@Column(name="followed_on")
	private LocalDateTime followedOn;
	
	
	public LocalDateTime getFollowedOn() {
		return followedOn;
	}

	public void setFollowedOn(LocalDateTime followedOn) {
		this.followedOn = followedOn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Users getUserFollower() {
		return userFollower;
	}

	public void setUserFollower(Users userFollower) {
		this.userFollower = userFollower;
	}

	public Users getUserToFollow() {
		return userToFollow;
	}

	public void setUserToFollow(Users userToFollow) {
		this.userToFollow = userToFollow;
	}

	public Followers(Users userFollower, Users userToFollow, LocalDateTime followedOn) {
		super();
		this.userFollower = userFollower;
		this.userToFollow = userToFollow;
		this.followedOn = followedOn;
	}
	Followers(){}

	

}
