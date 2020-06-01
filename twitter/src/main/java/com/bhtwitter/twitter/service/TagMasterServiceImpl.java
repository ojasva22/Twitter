package com.bhtwitter.twitter.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhtwitter.twitter.dao.TagMasterDAO;
import com.bhtwitter.twitter.entity.TagMaster;
import com.bhtwitter.twitter.entity.Tweets;
@Service
public class TagMasterServiceImpl implements TagMasterService{
	@Autowired
	private TagMasterDAO tagMasterDAO;
	/*
	public void saveTag(Tweets theTweet, String tag) {
		TagMaster tagM = tagMasterDAO.getTag(tag);
		if(tagM==null) {
			TagMaster newTag = new TagMaster();
			newTag.setTag(tag);
			newTag.setCreatedOn(LocalDateTime.now());
			tagMasterDAO.saveTag(tagM);
			//tweetMasterService.saveTagTweetMapping(newTag, theTweet);
			
		}
		else {
			tagM.setCreatedOn(LocalDateTime.now());
		//	tweetMasterService.saveTagTweetMapping(tagM, )
		}
		
	}*/
	@Override
	public TagMaster getTag(String tag) {
		return tagMasterDAO.getTag(tag);
		
	}
	@Override
	public void saveTag(TagMaster tag) {
		tagMasterDAO.saveTag(tag);
		
	}
	@Override
	public boolean getTagExists(String tag) {
		return tagMasterDAO.getTagExists(tag);
	}
	

}
