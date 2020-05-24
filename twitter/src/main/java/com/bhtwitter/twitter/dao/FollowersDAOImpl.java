package com.bhtwitter.twitter.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bhtwitter.twitter.entity.Followers;
import com.bhtwitter.twitter.entity.Users;
@Repository
public class FollowersDAOImpl implements FollowersDAO {
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void followerAdd(Followers theFollower) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(theFollower);


	}

	@Override
	public void unfollow(Users userF, Users userToUnfollow) {
		Session currentSession = entityManager.unwrap(Session.class);
		String sql = "delete from Followers where userFollower = :userF and userToFollow= :userToUnfollow";
		Query q = currentSession.createQuery(sql);
		q.setParameter("userF", userF);
		q.setParameter("userToUnfollow", userToUnfollow);
		q.executeUpdate();
		
	}

}
