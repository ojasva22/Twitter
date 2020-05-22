package com.bhtwitter.twitter.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bhtwitter.twitter.entity.UserType;
@Repository
public class UserTypeDAOImpl implements UserTypeDAO {

	@Autowired
	private EntityManager entityManager;
	@Override
	public void save(UserType theUserType) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theUserType);
	
	}

}
