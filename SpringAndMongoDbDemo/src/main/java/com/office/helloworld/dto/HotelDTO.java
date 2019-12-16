package com.office.helloworld.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.office.helloworld.model.Address;
import com.office.helloworld.model.Review;

public class HotelDTO {

	private String id;
	
	private String name;
		
	private Integer pricePerNight; 
	
	private Address address;
	
	private List<Review> reviews;
	
	private Integer ratepernight;
	private LocalDateTime datetime = LocalDateTime.now();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPricePerNight() {
		return pricePerNight;
	}
	public void setPricePerNight(Integer pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	public Integer getRatepernight() {
		return ratepernight;
	}
	public void setRatepernight(Integer ratepernight) {
		this.ratepernight = ratepernight;
	}
	public LocalDateTime getDatetime() {
		return datetime;
	}
	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}
	
/*	public HotelDTO() {
		
	}
	
	
	public HotelDTO(String id, String name, Integer pricePerNight, Address address, List<Review> reviews,
			Integer ratepernight) {
		super();
		this.id = id;
		this.name = name;
		this.pricePerNight = pricePerNight;
		this.address = address;
		this.reviews = reviews;
		this.ratepernight = ratepernight;

	}
	
	
	@Override
	public String toString() {
		return "HotelDTO [id=" + id + ", name=" + name + ", pricePerNight=" + pricePerNight + ", address=" + address
				+ ", reviews=" + reviews + ", ratepernight=" + ratepernight + ", datetime=" + datetime + "]";
	}
	
	
	*/
	
}
