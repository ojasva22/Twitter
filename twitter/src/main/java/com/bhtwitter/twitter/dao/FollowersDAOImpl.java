package com.bhtwitter.twitter.dao;

import java.util.ArrayList;
import java.util.List;

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
	@Autowired
	private UsersDAO userDAO;
	
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

	@Override
	public List<Users> getFollowers(int userId) {
		Users user = userDAO.getUserById(userId);
		List<Users> listUsers=new ArrayList<>();
		List<Followers> followers=  user.getFollowers();
		
		for(Followers fl : followers) {
			listUsers.add(fl.getUserFollower());
		}
		return listUsers;
	}

}
