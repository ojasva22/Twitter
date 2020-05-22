package com.bhtwitter.twitter.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bhtwitter.twitter.entity.Users;
@Repository
public class UsersDAOImpl implements UsersDAO {
	@Autowired
	private EntityManager entityManager;
	@Override
	public void save(Users theUser) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theUser);
	}
	@Override
	public Users getUserById(Integer id) {
		Session currentSession = entityManager.unwrap(Session.class);
		return currentSession.get(Users.class, id);
		
	}

}
