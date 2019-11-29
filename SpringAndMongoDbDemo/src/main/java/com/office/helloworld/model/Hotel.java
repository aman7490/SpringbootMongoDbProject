package com.office.helloworld.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author amandeep.singh
 *
 */
@Document(collection = "Hotels")
public class Hotel {

	@Id
	private String id;

	@Size(min=2, message="Name should have atleast two characters")
	private String name;
	@Indexed(direction = IndexDirection.ASCENDING)	
	private String pricePerNight; 
	@Valid
	private Address address;
	@Valid
	private List<Review> reviews;
	
	
	private Integer ratepernight;
	private LocalDateTime datetime = LocalDateTime.now();
	
	protected Hotel() {
		this.reviews = new ArrayList<>();
	}
	
	public Hotel(String name, Address address, List<Review> reviews, Integer ratepernight ) {
	
		this.name = name;
		
		this.address = address;
		this.reviews = reviews;
		this.ratepernight = ratepernight;
		
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	

	public Address getAddress() {
		return address;
	}
	
	public List<Review> getReviews() {
		return reviews;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

/*	public void setPricePerNight(int pricePerNight) {
		this.pricePerNight = pricePerNight;
	} */

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Integer getRatepernight() {
		return ratepernight;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	
		
}
