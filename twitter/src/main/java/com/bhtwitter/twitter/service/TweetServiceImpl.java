package com.bhtwitter.twitter.service;



import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bhtwitter.twitter.dao.TweetsDAO;
import com.bhtwitter.twitter.dao.UsersDAO;
import com.bhtwitter.twitter.entity.Tweets;
@Repository
public class TweetServiceImpl implements TweetService {
	private UsersDAO usersDAO;

	private TweetsDAO tweetsDAO;
	@Autowired
	public TweetServiceImpl(TweetsDAO theTweetsDAO, UsersDAO theUsersDAO) {
		tweetsDAO = theTweetsDAO;
		usersDAO = theUsersDAO;
	}
	
		
	
	@Override
	@Transactional
	public void save(Tweets theTweet, Integer userId) {
		
		theTweet.setTweetUserId(usersDAO.getUserById(userId));
		
		String t = theTweet.getTweet();
		System.out.println(t);
		int l=t.length();
		//length<=140
		//extracting tags
		ArrayList<String> listTags = new ArrayList<>();
		for(int i=0; i<l; i++)
		{
			//System.out.println(t.charAt(i));
			if(t.charAt(i)=='#')
			{
				i=i+1;
				String tag="";
				while(t.charAt(i)!='#' && t.charAt(i)!=' '&& i<l) {
					tag=tag+t.charAt(i);
					i++;
				}
				if(tag.length()!=0)
				listTags.add(tag);
				i=i-1;
			
			//System.out.println(tag);
			}
		}
		String[] tagArray = listTags.toArray(new String[listTags.size()]);
		theTweet.setTags(tagArray);
		tweetsDAO.save(theTweet);

	}



	@Override
	public List<Tweets> getTagRelatedTweets(String tag) {
		return tweetsDAO.getTagRelatedTweets(tag);
	}



	


}
