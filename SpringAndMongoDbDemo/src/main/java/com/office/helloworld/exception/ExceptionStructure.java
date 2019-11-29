package com.office.helloworld.exception;

import java.util.Date;

/**
 * @author amandeep.singh
 *
 */
public class ExceptionStructure {

	private Date Timestamp;
	private String ErrorMessage;
	private String ErrorDetails;
	
	
	
	public ExceptionStructure(Date Timestamp, String ErrorMessage, String ErrorDetails) {
		super();
		this.Timestamp = Timestamp;
		this.ErrorMessage = ErrorMessage;
		this.ErrorDetails = ErrorDetails;
	}

	public Date getTimestamp() {
		return Timestamp;
	}
	
	public String getErrorMessage() {
		return ErrorMessage;
	}
	public String getErrorDetails() {
		return ErrorDetails;
	}

	
}
