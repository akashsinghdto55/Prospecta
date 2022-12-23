package com.prospecta.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {

	
	@ExceptionHandler(MainException.class)
	public ResponseEntity<ErrorDetails> MainException(MainException exception,WebRequest web){
		
		ErrorDetails error = new ErrorDetails(LocalDateTime.now(),exception.getMessage(), web.getDescription(false));
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> exception(Exception e,WebRequest web){ 
		
		ErrorDetails error = new ErrorDetails(LocalDateTime.now(),e.getMessage(), web.getDescription(false));
		
		return new ResponseEntity<>(error,HttpStatus.EXPECTATION_FAILED);
	}


}
