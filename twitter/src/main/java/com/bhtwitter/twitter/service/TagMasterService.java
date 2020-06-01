package com.bhtwitter.twitter.service;

import com.bhtwitter.twitter.entity.TagMaster;
import com.bhtwitter.twitter.entity.Tweets;

public interface TagMasterService {
	public void saveTag(TagMaster tag);
	public TagMaster getTag(String tag);
	public boolean getTagExists(String tag);
}
