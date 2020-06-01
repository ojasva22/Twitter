package com.bhtwitter.twitter.dao;

import java.util.Comparator;

import com.bhtwitter.twitter.entity.Tweets;

public class EmployeeCreatedSort implements Comparator<Tweets> {

	@Override
	public int compare(Tweets arg0, Tweets arg1) {
		
		return arg1.getCreatedOn().compareTo(arg0.getCreatedOn());
	}

}
