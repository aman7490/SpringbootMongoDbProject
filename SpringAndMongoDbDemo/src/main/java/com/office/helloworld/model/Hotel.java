package com.office.helloworld.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Hotels")
public class Hotel {

	@Id
	private String id;
	private String name;
	@Indexed(direction = IndexDirection.ASCENDING)
	private String pricePerNight; 
	private Address address;
	private List<Review> reviews;
	private Integer ratepernight;
	
	
	protected Hotel() {
		this.reviews = new ArrayList<>();
	}
	
	public Hotel(String name, Address address, List<Review> reviews, String pricePerNight, Integer ratepernight ) {
	
		this.name = name;
		this.pricePerNight = pricePerNight;
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
	public String getPricePerNight() {
		return pricePerNight;
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



	
	
	
}
