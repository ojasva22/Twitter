package com.bhtwitter.twitter.service;

import org.springframework.stereotype.Repository;

import com.bhtwitter.twitter.dao.UserTypeDAO;
import com.bhtwitter.twitter.entity.UserType;
@Repository
public class UserTypeServiceImpl implements UserTypeService {
	private UserTypeDAO userTypeDAO;
	UserTypeServiceImpl(UserTypeDAO theUserTypeDAO){
		userTypeDAO=theUserTypeDAO;
	}
	@Override
	public void save(UserType userType) {
		// TODO Auto-generated method stub
		userTypeDAO.save(userType);

	}
	
}
