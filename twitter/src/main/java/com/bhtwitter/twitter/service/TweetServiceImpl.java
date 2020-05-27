package com.bhtwitter.twitter.service;




import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhtwitter.twitter.dao.TweetsDAO;
import com.bhtwitter.twitter.entity.Tweets;
import com.bhtwitter.twitter.entity.Users;
import com.bhtwitter.twitter.exception.TweetNotFoundException;
import com.bhtwitter.twitter.exception.UserNotFoundException;
@Service
public class TweetServiceImpl implements TweetService {
	@Autowired
	private UsersService usersService;

	private TweetsDAO tweetsDAO;
	@Autowired
	public TweetServiceImpl(TweetsDAO theTweetsDAO) {
		tweetsDAO = theTweetsDAO;
		
	}
	
		
	
	@Override
	@Transactional
	public void save(Tweets theTweet, Integer userId) {
		
		Users user = usersService.getUserById(userId);
		if(user==null)
			throw new UserNotFoundException("User Not Found");
		theTweet.setTweetUserId(user);
		
		String t = theTweet.getTweet();
		System.out.println(t);
		int l=t.length();
		//length<=140
		//extracting tags
		
		Set<String> listTags = new TreeSet<>();
		for(int i=0; i<l; i++)
		{
			//System.out.println(t.charAt(i));
			if(t.charAt(i)=='#')
			{
				i=i+1;
				String tag="";
				while((i<l) && (t.charAt(i)!='#' && t.charAt(i)!=' ')) {
					tag=tag+t.charAt(i);
					i++;
				}
				if(tag.length()!=0)
				listTags.add(tag);
				i=i-1;
			
			//System.out.println(tag);
			}
		}
		//String[] tagArray = listTags.toArray(new String[listTags.size()]);
		theTweet.setTags(new ArrayList<>(listTags));
		tweetsDAO.save(theTweet);

	}



	@Override
	
	public List<Tweets> getTagRelatedTweets(String tag) {
		return tweetsDAO.getTagRelatedTweets(tag);
	}



	@Override
	@Transactional
	public void delete(int tweetId, int userId) throws TweetNotFoundException {
		//Check if tweet was posted by user else error
		
		Users user = usersService.getUserById(userId);
			if(user==null)
				throw new UserNotFoundException("User not found");
			try {
				Tweets t = tweetsDAO.getTweetById(tweetId);
			}catch(Exception e) {
			
				throw new TweetNotFoundException("Tweet not found");
	}
			tweetsDAO.delete(tweetId);
		
			
		}
		




	@Override
	@Transactional
	public Tweets getTweetById(int id) {
		return tweetsDAO.getTweetById(id);
	}



	@Override
	public List<Users> getTweetLikedByUsers(int tweetId) {
		Tweets theTweet = tweetsDAO.getTweetById(tweetId);
		return tweetsDAO.getTweetLikedByUsers(theTweet);
	}



	@Override
	public List<Tweets> getAllTweets() {
		return tweetsDAO.getAllTweets();
	}



	@Override
	public List<String> getTrendingTags() {
		List<Tweets> tweets;
		try {
		tweets = tweetsDAO.getRecentTweets();
		}catch(Exception e) {
			throw new TweetNotFoundException("Tweets Not Found");
		}
		HashMap<String, Integer> hm = new HashMap<>();
		for(Tweets t : tweets) {
			
			List<String> tags = t.getTags();
			for(String tag : tags)
			{
				if(hm.containsKey(tag)) {
					int ct = hm.get(tag);
					ct=ct+1;
					hm.put(tag,  ct);					
				}
				else {
					hm.put(tag, 1);
				}
			}
		}
			
			Map<String, Integer> sortedMap = sortByValue(hm);
			ArrayList<String> res = new ArrayList<>();
			ArrayList<String> keys = new ArrayList<>(sortedMap.keySet());
			int l = keys.size();
			int i=0;
			while(i<l && i<10)
			{
				res.add(keys.get(i));
				i++;
			}
			return res;
			
			
			
		}
	
	
	public static Map<String, Integer> sortByValue(final Map<String, Integer> wordCounts) {
        return wordCounts.entrySet()
                .stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
	
	



	


}
