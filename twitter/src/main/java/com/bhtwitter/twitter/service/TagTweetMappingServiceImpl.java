package com.bhtwitter.twitter.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhtwitter.twitter.dao.TagTweetMappingDAO;
import com.bhtwitter.twitter.entity.TweetMapping;
import com.bhtwitter.twitter.entity.Tweets;
@Service
public class TagTweetMappingServiceImpl implements TagTweetMappingService {
	@Autowired
	private TagMasterService tagMasterService;
	@Autowired
	private TagTweetMappingDAO tagTweetMappingDAO;
	@Override
	public void saveMapping(String tag, Tweets theTweet) {
		TweetMapping tm = new TweetMapping();
		tm.setCreatedOn(LocalDateTime.now());
		tm.setTagId(tagMasterService.getTag(tag));
		tm.setTweetID(theTweet);
		tagTweetMappingDAO.saveMapping(tm);

	}
	@Override
	public List<TweetMapping> getMapping(int tweetId) {
		return tagTweetMappingDAO.getMapping(tweetId);
	}

}
