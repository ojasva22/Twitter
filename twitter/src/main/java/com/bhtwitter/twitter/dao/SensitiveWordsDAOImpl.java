package com.bhtwitter.twitter.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bhtwitter.twitter.entity.SensitiveWords;
@Repository
public class SensitiveWordsDAOImpl implements SensitiveWordsDAO {
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<String> getSensitiveWords() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query q = currentSession.createQuery("select word from Sensitive Words where active = true");
		List<String> words = q.getResultList();
		return words;
	}

	@Override
	public void addSensitiveWords(SensitiveWords theSensitiveWord) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(theSensitiveWord);
		
	}

	@Override
	public void updateWord(SensitiveWords sensitiveWord) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.update(sensitiveWord);
		
	}

	@Override
	public SensitiveWords findByWord(String word) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query q = currentSession.createQuery("from SensitiveWords where word = :word");
		q.setParameter("word", word);
		SensitiveWords sw = (SensitiveWords) q.uniqueResult();
		return sw;
	}

	@Override
	public boolean isWordSensitive(String word) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query q = currentSession.createQuery("from SensitiveWords where word = :word and active = true").setParameter("word", word);
		SensitiveWords sw = (SensitiveWords) q.uniqueResult();
		if(sw==null)
		return false;
		return true;
	}

}
