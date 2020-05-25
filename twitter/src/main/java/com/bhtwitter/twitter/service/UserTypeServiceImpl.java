package com.bhtwitter.twitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhtwitter.twitter.dao.UserTypeDAO;
import com.bhtwitter.twitter.entity.UserType;
@Service
public class UserTypeServiceImpl implements UserTypeService {
	@Autowired
	private UserTypeDAO userTypeDAO;
	
	@Override
	public UserType getUserType(String role) {
		return userTypeDAO.getUserType(role);
		}
	
}
