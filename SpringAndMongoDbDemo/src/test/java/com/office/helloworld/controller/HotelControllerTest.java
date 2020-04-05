package com.office.helloworld.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.BeanUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.office.helloworld.dto.HotelDTO;
import com.office.helloworld.model.Address;
import com.office.helloworld.model.Hotel;
import com.office.helloworld.model.Review;
import com.office.helloworld.service.ServiceImpl;

class HotelControllerTest {

	//	private MockMvc mockMvc;
	
	@InjectMocks
	HotelController hotelcontroller;

	@Mock
	ServiceImpl service;

	HotelDTO hoteldto;
	Hotel hotel;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	//	hotelcontroller = new HotelController();
	//	mockMvc= MockMvcBuilders.standaloneSetup(hotelcontroller).build();
		
		Address address = new Address("Mockcity", "MockCountry");
		Review review =  new Review("Mockuser", 7, true); 
		Review review2 = new Review("MockUser2", 7, true);
		List<Review> reviewlist = Arrays.asList(review,review2);
		hotel = new Hotel("Mockid","Mockname", 7, address, reviewlist, 12);
	//	hoteldto = new HotelDTO("Mockid","Mockname", 7, address, reviewlist, 12);
	//	BeanUtils.copyProperties(hotel, hoteldto);
		
	}

	
	@Test
	final void getallhotels() {
		List<Hotel> hotels=Arrays.asList(hotel);
		when(service.getallhoteldetails()).thenReturn(hotels);
		List<Hotel> hotelss = hotelcontroller.getallhotels();
		assertNotNull(hotelss);
		assertEquals(hotels.get(0).getId(), hotelss.get(0).getId());
		
	}
	
	@Test
	final void testGetbycity() {
		Address address = new Address("Mockcity", "MockCountry");
		Review review =  new Review("Mockuser", 7, true); 
		Review review2 = new Review("MockUser2", 7, true);
		List<Review> reviewlist = Arrays.asList(review,review2);
		Hotel hotel = new Hotel("Mockid","Mockname", 7, address, reviewlist, 12);	
		List<Hotel> hotels = Arrays.asList(hotel);
		when(service.findbycitydetails(anyString())).thenReturn(hotels);
		List<Hotel> hottels = hotelcontroller.getbycity("Mockcity");
		assertNotNull(hottels);
		assertEquals(hotels.get(0).getAddress().getCity(), hottels.get(0).getAddress().getCity());	
	}
	
	@Test
	final void addhotel() {
		
		
		Address address = new Address("Mockcity", "MockCountry");
		Review review =  new Review("Mockuser", 7, true); 
		Review review2 = new Review("MockUser2", 7, true);
		List<Review> reviewlist = Arrays.asList(review,review2);
		hotel = new Hotel("Mockid","Mockname", 7, address, reviewlist, 12);
		
	
		when(service.addhoteldetails(any(HotelDTO.class))).thenReturn(hotel);
		hoteldto=null;
		hoteldto.setId(hotel.getId());
		hoteldto.setName(hotel.getName());
		hoteldto.setPricePerNight(hotel.getPricePerNight());
		hoteldto.setRatepernight(hotel.getRatepernight());
	//	hoteldto.setReviews(hotel.getReviews().get(0).getUsername());
		hoteldto.setReviews(reviewlist);
		hoteldto.setAddress(address);
	//	hoteldto.setDatetime();
		
		//BeanUtils.copyProperties(hotel, hoteldto);
		
		Hotel hotel1 = hotelcontroller.addhotel(hoteldto);
		assertNotNull(hotel1);
		assertEquals(hoteldto.getId(), hotel1.getId());
		assertEquals(hoteldto.getName(), hotel1.getName());
		assertEquals(hoteldto.getPricePerNight(), hotel1.getPricePerNight());
		assertEquals(hoteldto.getRatepernight(), hotel1.getRatepernight());
		assertEquals(hoteldto.getReviews().get(0).getRating(), hotel1.getReviews().get(0).getRating());		
	}
	
	@Test
	final void updatehotel() {
		
		Address address = new Address("Mockcity", "MockCountry");
		Review review =  new Review("Mockuser", 7, true); 
		Review review2 = new Review("MockUser2", 7, true);
		List<Review> reviewlist = Arrays.asList(review,review2);
		Hotel hotel = new Hotel("Mockid","Mockname", 7, address, reviewlist, 12);
		
		BeanUtils.copyProperties(hotel, hoteldto);
		
		when(service.updatehoteldetails(any(HotelDTO.class))).thenReturn(hotel);
		
		Hotel hotel1 = hotelcontroller.updatehotel(hoteldto);
		
		assertNotNull(hotel1);
		assertEquals(hotel.getId(), hotel1.getId());
		
		
	}
	
	@Test
	final void gethoteldetailsbyid() {
		
		when(service.gethoteldetailssbyid(anyString())).thenReturn(hotel);
		Hotel hotel1 = hotelcontroller.gethoteldetailsbyid(anyString());
		
		assertNotNull(hotel1);
		assertEquals(hotel.getId(), hotel1.getId());
		
	}
	
	

}
