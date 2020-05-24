package com.bhtwitter.twitter.dao;

import java.util.List;

import javax.persistence.EntityManager;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bhtwitter.twitter.entity.Tweets;
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
		String sql = "from Tweets t join t.tags tt where tt= :tSearch";
		Query query = currentSession.createQuery(sql).setString("tSearch", tag);
		//query.setParameter("tSearch", tag);
		List<Tweets> resTweet = (List<Tweets>)query.getResultList();
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
	
}
