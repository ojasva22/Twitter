package com.bhtwitter.twitter.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bhtwitter.twitter.entity.UserType;
@Repository
public class UserTypeDAOImpl implements UserTypeDAO {

	@Autowired
	private EntityManager entityManager;
	
	

	@Override
	public UserType getUserType(String role) {
		Session currenSession = entityManager.unwrap(Session.class);
		Query q = currenSession.createQuery("from UserType where type= :role");
		q.setParameter("role", role.toUpperCase());
		return (UserType) q.getSingleResult();
		
	
	}

}
