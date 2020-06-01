package com.bhtwitter.twitter.exception;

import java.time.LocalDateTime;

import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	/*
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(Exception exc)
	{
		ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), exc.getMessage(), LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		
	}*/
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> userAlreadyExists(AlreadyExists exc){
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		
		
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorResponse error = new ErrorResponse();
		
		error.setMessage(ex.getBindingResult().getFieldError().getDefaultMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleException(UserNotFoundException exc){
		ErrorResponse error = new ErrorResponse();
		error.setMessage(exc.getMessage());
		error.setTimestamp(LocalDateTime.now());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TweetNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(TweetNotFoundException exc){
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage("Tweet not found ");
		error.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

}
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Object> handleException(DataIntegrityViolationException exc){
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.CONFLICT.value());
		error.setMessage(exc.getLocalizedMessage());
		error.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.CONFLICT);
		
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> handleException(ConstraintViolationException exc){
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getConstraintViolations().iterator().next().getMessage());
		error.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	
}
	
	@ExceptionHandler(FollowerException.class)
	public ResponseEntity<Object> handleException(FollowerException exc){
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
}
	@ExceptionHandler(UniqueException.class)
	public ResponseEntity<Object> handleException(UniqueException exc){
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
}
	@ExceptionHandler(LengthException.class)
	public ResponseEntity<Object> handleException(LengthException exc){
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
}
	@ExceptionHandler(NotSensitiveException.class)
	public ResponseEntity<Object> handleException(NotSensitiveException exc){
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
}
	
	
	
}
