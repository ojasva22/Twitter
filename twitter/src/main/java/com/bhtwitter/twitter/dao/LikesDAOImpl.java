package com.bhtwitter.twitter.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bhtwitter.twitter.entity.Likes;
import com.bhtwitter.twitter.entity.Tweets;
import com.bhtwitter.twitter.entity.Users;

@Repository
public class LikesDAOImpl implements LikesDAO {
	
	@Autowired
	private EntityManager entityManager;
	@Override
	public void likeTweet(Likes theLike) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(theLike);

	}
	@Override
	public void unlikeTweet(Users user, Tweets tweet) {
		Session currentSession = entityManager.unwrap(Session.class);
	
		Query q = currentSession.createQuery("delete from Likes where userLiked = :userId and tweetLiked =:tweetId");
		q.setParameter("userId", user);
		q.setParameter("tweetId", tweet);
		q.executeUpdate();
		
	}
	

}
