package com.office.helloworld.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author amandeep.singh
 *
 */
public class Review {

	@Email(message = "Please enter correct email address")
	private String username;
	@Min(value =1, message ="minimum 1")
	@Max(value = 10, message ="maximum 10")
	private int rating;
	private boolean approved;
	
	
	protected Review () {
		
	}
	
	public Review(String username, int rating, boolean approved) {
		
		this.username = username;
		this.rating = rating;
		this.approved = approved;
	}
	public String getUsername() {
		return username;
	}
	public int getRating() {
		return rating;
	}
	public boolean isApproved() {
		return approved;
	}
	
	
	
	
	
}
