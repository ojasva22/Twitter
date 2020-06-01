package com.bhtwitter.twitter.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bhtwitter.twitter.entity.Likes;
import com.bhtwitter.twitter.entity.TagMaster;
import com.bhtwitter.twitter.entity.TweetMapping;
import com.bhtwitter.twitter.entity.Tweets;
import com.bhtwitter.twitter.entity.Users;
@Repository
public class TweetsDAOImpl implements TweetsDAO {
	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	public void save(Tweets theTweet) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.persist(theTweet);

	}
	
	@Override
	public List<Tweets> getTagRelatedTweets(String tags, int page) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query q = currentSession.createQuery("from TagMaster where tag = :tags").setParameter("tags", tags);
		TagMaster tm = (TagMaster) q.uniqueResult();
		List<TweetMapping> tweetMap = tm.getTweets();
		
		List<Tweets> resTweet = new ArrayList<>();
		for(TweetMapping tMap : tweetMap) {
			resTweet.add(tMap.getTweetID());
		}
		return resTweet;
	}
	@Override
	public void delete(int tweetId) {
		Session currentSession  = entityManager.unwrap(Session.class);
		/*
		Query q = currentSession.createQuery("delete from Tweets where tweetId = :tweetId");
		q.setParameter("tweetId", tweetId);
		q.executeUpdate();
		*/
		//Query q = currentSession.createQuery("from Tweets where tweetId = :tweetId");
		//q.setParameter("tweetId", tweetId);
		Tweets t = getTweetById(tweetId);
		currentSession.remove(t);
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
	public List<Tweets> getAllTweets(int page, String sort) {
		int pageSize = 10;
		Session CurrentSession = entityManager.unwrap(Session.class);
		Query q = CurrentSession.createQuery("from Tweets");
		q.setFirstResult((page-1)*pageSize);
		q.setMaxResults(20);
		
		List<Tweets> tweets = q.getResultList();
		Collections.sort(tweets, new EmployeeCreatedSort());
		
		return tweets;
	}

	@Override
	public List<String> getRecentTweets() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query q = currentSession.createQuery("from TweetMapping where createdOn > :time");
		LocalDateTime time = LocalDateTime.now().minusDays(1);
		q.setParameter("time", time);
		List<TweetMapping> tweetMapping = q.getResultList();
		List<String> resTags = new ArrayList<>();
		for(TweetMapping tm : tweetMapping) {
			resTags.add(tm.getTagId().getTag());
		}
		return resTags;
		
		
		
		
	}

	

	
	
}
