package com.bhtwitter.twitter.rest;

import java.nio.channels.AcceptPendingException;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhtwitter.twitter.entity.SensitiveWords;
import com.bhtwitter.twitter.exception.AlreadyExists;
import com.bhtwitter.twitter.exception.LengthException;
import com.bhtwitter.twitter.exception.UserNotFoundException;
import com.bhtwitter.twitter.service.SensitiveWordsService;

@RestController
@RequestMapping(value = "/admin")
public class SensitiveWordsRestController {
	@Autowired
	private SensitiveWordsService sensitiveWordsService;
	
	@PostMapping("/sensitiveWords")
	public ResponseEntity<?> addSensitiveWord(@RequestBody SensitiveWords theSensitiveWord) {
		if(theSensitiveWord.getWord().length()>140)
		{
			throw new LengthException("Length should be less than 140");
		}
		SensitiveWords word = sensitiveWordsService.findByWord(theSensitiveWord.getWord());
		if(word==null) {
		theSensitiveWord.setCreatedOn(LocalDateTime.now());
		theSensitiveWord.setUpdatedOn(LocalDateTime.now());
		theSensitiveWord.setActive(true);
		sensitiveWordsService.addSensitive(theSensitiveWord);
		return new ResponseEntity<SensitiveWords>(theSensitiveWord, HttpStatus.OK);
		}
		else
		{
			if(word.isActive()) {
				throw new AlreadyExists("Word already present");
			}
			else {
				word.setActive(true);
				word.setUpdatedOn(LocalDateTime.now());
				sensitiveWordsService.updateWord(word);
			}
			return new ResponseEntity<SensitiveWords>(word, HttpStatus.OK);
		}
		
	}
	
	@PutMapping("/sensitiveWords/{word}")
	public ResponseEntity<?> updateWord(@PathVariable String word) throws Exception{
		
		SensitiveWords sensitiveWord = sensitiveWordsService.findByWord(word);
		if(sensitiveWord==null) {
			throw new UserNotFoundException("Word not Found");
		}
		boolean active = sensitiveWord.isActive();
		if(active==false) {
			throw new AlreadyExists("Already removed");
		}
			sensitiveWord.setActive(false);
			sensitiveWord.setUpdatedOn(LocalDateTime.now());
			sensitiveWordsService.updateWord(sensitiveWord);
			return new ResponseEntity<SensitiveWords>(sensitiveWord, HttpStatus.OK);
		}
	}


