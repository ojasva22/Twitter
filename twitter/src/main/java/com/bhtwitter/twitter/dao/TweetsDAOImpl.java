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
		String sql = "from tweets where :tag in indices(tags)";
		Query query = currentSession.createQuery(sql);
		query.setParameter("tag", tag);
		List<Tweets> resTweet = (List<Tweets>)query.getResultList();
		return resTweet;
	}
	
}
