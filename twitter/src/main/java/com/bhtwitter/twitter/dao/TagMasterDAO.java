package com.bhtwitter.twitter.dao;

import com.bhtwitter.twitter.entity.TagMaster;
import com.bhtwitter.twitter.entity.Tweets;

public interface TagMasterDAO {
	public void saveTag(TagMaster theTagMaster);
	public TagMaster getTag(String tag);
	public boolean getTagExists(String tag);
}
