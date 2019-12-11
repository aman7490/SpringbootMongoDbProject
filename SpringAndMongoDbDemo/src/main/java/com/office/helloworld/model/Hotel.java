package com.office.helloworld.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
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
	private Integer pricePerNight; 
	@Valid
	private Address address;
	@Valid
	private List<Review> reviews;
	
	private Integer ratepernight;
	private LocalDateTime datetime = LocalDateTime.now();
	
	public Hotel() {
		this.reviews = new ArrayList<>();
	}
	
	public Hotel(String id, String name, Integer pricePerNight, Address address, List<Review> reviews, Integer ratepernight ) {
	
		this.id=id;
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

	public void setPricePerNight(Integer pricePerNight) {
		this.pricePerNight = pricePerNight;
	} 

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Integer getRatepernight() {
		return ratepernight;
	}

	public Integer getPricePerNight() {
		return pricePerNight;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", pricePerNight=" + pricePerNight + ", address=" + address
				+ ", reviews=" + reviews + ", ratepernight=" + ratepernight + ", datetime=" + datetime + "]";
	}

	
		
}
