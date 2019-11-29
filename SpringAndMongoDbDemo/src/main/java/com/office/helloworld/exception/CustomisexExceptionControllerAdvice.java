package com.office.helloworld.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author amandeep.singh
 *
 */
@ControllerAdvice
@RestController
public class CustomisexExceptionControllerAdvice extends ResponseEntityExceptionHandler {
	// This exception is for all
@ExceptionHandler(Exception.class)
public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
	
	ExceptionStructure exceptionStructure = new ExceptionStructure(new Date(), ex.getMessage(), request.getDescription(false));
	
	return new ResponseEntity<Object>(exceptionStructure, HttpStatus.INTERNAL_SERVER_ERROR);
	
}
// this is for if hotel not found
@ExceptionHandler(HotelNotFoundException.class)
public final ResponseEntity<Object> handleHotelNotFoundExceptions(HotelNotFoundException ex, WebRequest request){
	
	ExceptionStructure exceptionStructure = new ExceptionStructure(new Date(), ex.getMessage(), request.getDescription(false));
	
	return new ResponseEntity<Object>(exceptionStructure, HttpStatus.NOT_FOUND);
	
}
/**
 *
 */
// This I have override from the responseentityexceptionhandler class to give custom response.
@Override
protected ResponseEntity<Object> handleMethodArgumentNotValid(
		MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	ExceptionStructure exceptionStructure = new ExceptionStructure(new Date(), "Validatio Error",ex.getBindingResult().toString());
	return new ResponseEntity<Object>(exceptionStructure, HttpStatus.BAD_REQUEST);
}



}
