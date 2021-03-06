package com.office.helloworld.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author amandeep.singh
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class HotelNotFoundException extends RuntimeException {
	private static final transient Logger log= LoggerFactory.getLogger(HotelNotFoundException.class);
	
	private static final long serialVersionUID = 1L;
	public HotelNotFoundException(String message) {
		
		super(message);
		log.error("Hotel not found exception from hotel not found class");

	}


}
