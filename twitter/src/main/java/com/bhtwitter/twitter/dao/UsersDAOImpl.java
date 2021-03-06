package com.bhtwitter.twitter.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.bhtwitter.twitter.entity.Users;
import com.bhtwitter.twitter.exception.UserNotFoundException;
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
	@Override
	public Users getUserByUsername(String name) throws UserNotFoundException {
		Session currentSession = entityManager.unwrap(Session.class);
		Users x;		
		Query q = currentSession.createQuery("from Users where username like :name");
		q.setParameter("name", name);		
		 x = (Users) q.uniqueResult();		
		return x;
		
	}
	@Override
	public List<Users> getUsers() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query q = currentSession.createQuery("from Users");
		List<Users> userList = q.getResultList();
		return userList;
		
	}
	@Override
	public boolean emailAlreadyExists(String email) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query q = currentSession.createQuery("select count(username) from Users where email = :email");
		q.setParameter("email", email);
		long x = (Long)q.uniqueResult();
		if(x>0)
			return true;
		else
			return false;
	}
	
	@Override
	public boolean userAlreadyExists(String name) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query q = currentSession.createQuery("select count(username) from Users where username = :name");
		q.setParameter("name", name);
		long x = (Long)q.uniqueResult();
		if(x>0)
			return true;
		else
			return false;
	}

}
