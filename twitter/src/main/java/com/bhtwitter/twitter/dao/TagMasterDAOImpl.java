package com.bhtwitter.twitter.dao;

import javax.persistence.EntityManager;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bhtwitter.twitter.entity.TagMaster;
@Repository
public class TagMasterDAOImpl implements TagMasterDAO {
	@Autowired
	private EntityManager entityManager;
	@Override
	public void saveTag(TagMaster theTagMaster) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.persist(theTagMaster);

	}
	@Override
	public TagMaster getTag(String tag)
	{
		Session currentSession = entityManager.unwrap(Session.class);
		Query q = currentSession.createQuery("from TagMaster where tag = :tag");
		q.setParameter("tag", tag);
		TagMaster tagRes = (TagMaster) q.uniqueResult();
				return tagRes;
	}
	@Override
	public boolean getTagExists(String tag) {
		if(getTag(tag)!=null)
			return true;
		return false;
	}

}
