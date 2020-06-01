package com.bhtwitter.twitter.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bhtwitter.twitter.entity.TweetMapping;
@Repository
public class TagTweetMappingDAOimpl implements TagTweetMappingDAO {
	@Autowired
	private EntityManager entityManager;
	@Override
	public void saveMapping(TweetMapping theTweetMapping) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(theTweetMapping);

	}
	@Override
	public List<TweetMapping> getMapping(int tweetId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query q = currentSession.createQuery("from TweetMapping where tweetId = :tweetId").setParameter("tweetId", tweetId);
		return q.getResultList();
		
		
	}
	
	

}
