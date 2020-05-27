package com.bhtwitter.twitter.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bhtwitter.twitter.entity.Likes;
import com.bhtwitter.twitter.entity.Tweets;
import com.bhtwitter.twitter.entity.Users;
@Repository
public class TweetsDAOImpl implements TweetsDAO {
	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	public void save(Tweets theTweet) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theTweet);

	}
	
	@Override
	public List<Tweets> getTagRelatedTweets(String tag) {
		Session currentSession = entityManager.unwrap(Session.class);
	//	entityManager.contains(entity)
		Query<Tweets> q = currentSession.createQuery("");
		q.setParameter("t", tag);
		List<Tweets> resTweet = q.getResultList();
		return resTweet;
	}
	@Override
	public void delete(int tweetId) {
		Session currentSession  = entityManager.unwrap(Session.class);
		Query q = currentSession.createQuery("delete from Tweets where tweetId = :tweetId");
		q.setParameter("tweetId", tweetId);
		q.executeUpdate();
	}
	
	@Override
	public Tweets getTweetById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query q = currentSession.createQuery("from Tweets where tweetId = :id");
		q.setParameter("id",id);
		Tweets t = (Tweets) q.getSingleResult();
		return t;
	}

	@Override
	public List<Users> getTweetLikedByUsers(Tweets theTweet) {
		List<Likes> likes = theTweet.getLikedBy();
		ArrayList<Users> userList = new ArrayList<>();
		for(Likes l : likes) {
			userList.add(l.getUserLiked());
			
		}
		return userList;
	}

	@Override
	public List<Tweets> getAllTweets() {
		Session CurrentSession = entityManager.unwrap(Session.class);
		Query q = CurrentSession.createQuery("from Tweets");
		List<Tweets> tweets = q.getResultList();
		return tweets;
	}

	@Override
	public List<Tweets> getRecentTweets() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query q = currentSession.createQuery("from Tweets where createdOn > :time");
		LocalDateTime time = LocalDateTime.now().minusDays(1);
		q.setParameter("time", time);
		List<Tweets> tweets = q.getResultList();
		return tweets;
		
		
		
		
	}

	

	
	
}
