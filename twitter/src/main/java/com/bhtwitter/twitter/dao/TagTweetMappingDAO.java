package com.bhtwitter.twitter.dao;

import java.util.List;

import com.bhtwitter.twitter.entity.TweetMapping;

public interface TagTweetMappingDAO {
	public void saveMapping(TweetMapping theTweetMapping);

	public List<TweetMapping> getMapping(int tweetId);
}
