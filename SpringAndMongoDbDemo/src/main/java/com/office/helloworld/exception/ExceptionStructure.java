package com.office.helloworld.exception;

import java.util.Date;

/**
 * @author amandeep.singh
 *
 */
public class ExceptionStructure {

	private Date timestamp;
	private String errorMessage;
	private String errorDetails;
	
	
	
	public ExceptionStructure(Date timestamp, String errorMessage, String errorDetails) {
		super();
		this.timestamp = timestamp;
		this.errorMessage = errorMessage;
		this.errorDetails = errorDetails;
	}

	public Date getTimestamp() {
		return timestamp;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public String getErrorDetails() {
		return errorDetails;
	}

	
}
