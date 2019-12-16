package com.office.helloworld.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.jboss.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.BeanUtils;

import com.office.helloworld.dto.HotelDTO;
import com.office.helloworld.exception.HotelNotFoundException;
import com.office.helloworld.model.Address;
import com.office.helloworld.model.Hotel;
import com.office.helloworld.model.Review;
import com.office.helloworld.repository.HotelRepository;

class ServiceImplTest {

	Logger log = Logger.getLogger(ServiceImplTest.class);
	
	@InjectMocks
	ServiceImpl serviceimpl;
	
	@Mock
	HotelRepository hotelRepository;
	
	Hotel hotel;
	HotelDTO hoteldto;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this); 
		/* this will instantiate the serviceimpl object. */
		Address address = new Address("Mockcity", "MockCountry");
		Review review =  new Review("Mockuser", 7, true); 
		Review review2 = new Review("MockUser2", 7, true);
		List<Review> reviewlist = Arrays.asList(review,review2);
//		hoteldto = new HotelDTO("Mockid1","Mockname", 7, address, reviewlist, 12);
		
	}

	@Test
	final void testGethoteldetailssbyid() {
		Address address = new Address("Mockcity", "MockCountry");
		Review review =  new Review("Mockuser", 7, true); 
		Review review2 = new Review("MockUser2", 7, true);
		List<Review> reviewlist = Arrays.asList(review,review2);
		Hotel hotel = new Hotel("Mockid","Mockname", 7, address, reviewlist, 12);	
		when(hotelRepository.findByhotelId(anyString())).thenReturn(hotel);
		Hotel hotel1= serviceimpl.gethoteldetailssbyid("Mockid");
		assertNotNull(hotel1);
		assertEquals("Mockid", hotel1.getId());
		
 	}
	
	// Second Test is if exception is changed in that method by some other developer then here in this test
	// it will tell us that expected exception is hotelnotfound not the other exception, 
	//right now i have changes my exception is serviceImpl to null pointer exception.
	@Test
	final void testGetHoteldetailssbyid_HotelNotFoundException() {
		when(hotelRepository.findByhotelId(anyString())).thenReturn(null);
		Assertions.assertThrows(HotelNotFoundException.class,			
				() -> {
					serviceimpl.gethoteldetailssbyid("Mockid");
					} 
				);
	}
	
	@Test
	final void getallhoteldetails() {
		Address address = new Address("Mockcity", "MockCountry");
		Review review =  new Review("Mockuser", 7, true); 
		Review review2 = new Review("MockUser2", 7, true);
		List<Review> reviewlist = Arrays.asList(review,review2);
		Hotel hotel1 = new Hotel("Mockid1","Mockname", 7, address, reviewlist, 12);
		Hotel hotel2 = new Hotel("Mockid2","Mockname", 7, address, reviewlist, 12);
		//HotelDTO hoteldto1 = new HotelDTO("Mockid1","Mockname", 7, address, reviewlist, 12);
		//HotelDTO hoteldto2 = new HotelDTO("Mockid1","Mockname", 7, address, reviewlist, 12);
		//List<HotelDTO> hoteldtos = Arrays.asList(hoteldto1,hoteldto2);
		List<Hotel> hotels = Arrays.asList(hotel1,hotel2);
		
		when(hotelRepository.findAll()).thenReturn(hotels);	
		List<Hotel> hotelss = serviceimpl.getallhoteldetails();
		assertNotNull(hotelss);
		assertEquals("Mockid1", hotelss.get(0).getId());
	}
	
	@Test
	final void testgetallhoteldetails_HotelNotFoundException() {
		when(hotelRepository.findAll()).thenReturn(null);
	//	Hotel hotels = null;
		Assertions.assertThrows(HotelNotFoundException.class,
				
				() -> {
					serviceimpl.getallhoteldetails();
					} 
				);
	}
	
	@Test
	final void getbyratedetails() {
		Address address = new Address("Mockcity", "MockCountry");
		Review review =  new Review("Mockuser", 7, true); 
		Review review2 = new Review("MockUser2", 7, true);
		List<Review> reviewlist = Arrays.asList(review,review2);
		Hotel hotel = new Hotel("Mockid","Mockname", 7, address, reviewlist, 12);	
		List<Hotel> hotels = Arrays.asList(hotel);
		when(hotelRepository.findByratepernightLessThan(anyInt())).thenReturn(hotels);
		List<Hotel> allhotels = serviceimpl.getbyratedetails(anyInt());
		assertEquals("12", allhotels.get(0).getRatepernight().toString());	
	}
	
	@Test
	final void Testgetbyratedetails() {
		when(hotelRepository.findByratepernightLessThan(anyInt())).thenReturn(null);
		Assertions.assertThrows(HotelNotFoundException.class,
				
				() -> {
					serviceimpl.getbyratedetails(anyInt());
					} 
				);
	}
	
	@Test
	final void findbycitydetails() {
		
		Address address = new Address("Mockcity", "MockCountry");
		Review review =  new Review("Mockuser", 7, true); 
		Review review2 = new Review("MockUser2", 7, true);
		List<Review> reviewlist = Arrays.asList(review,review2);
		Hotel hotel = new Hotel("Mockid","Mockname", 7, address, reviewlist, 12);	
		List<Hotel> hotels = Arrays.asList(hotel);
		when(hotelRepository.findByCity(anyString())).thenReturn(hotels);
		List<Hotel> allhotels = serviceimpl.findbycitydetails(anyString());
		assertEquals("Mockcity", allhotels.get(0).getAddress().getCity());		
	}
	
	
	@Test
	final void testfindbycitydetails() {
		when(hotelRepository.findByCity("Mockcity")).thenReturn(null);
		Assertions.assertThrows(HotelNotFoundException.class,
				
				() -> {
					serviceimpl.findbycitydetails("Mockcity");
					
					} 
				);
	}
	
	@Test 
	final void findbycountrydetails() {
		
		Address address = new Address("Mockcity", "MockCountry");
		Review review =  new Review("Mockuser", 7, true); 
		Review review2 = new Review("MockUser2", 7, true);
		List<Review> reviewlist = Arrays.asList(review,review2);
		Hotel hotel = new Hotel("Mockid","Mockname", 7, address, reviewlist, 12);	
		List<Hotel> hotels = Arrays.asList(hotel);
		when(hotelRepository.findByCountry(anyString())).thenReturn(hotels);
		List<Hotel> allhotels = serviceimpl.findbycountrydetails(anyString());
		assertEquals("MockCountry", allhotels.get(0).getAddress().getCountry());
		
	}
	
	@Test
	final void testfindbycountrydetails() {
		
		when(hotelRepository.findByCountry(anyString())).thenReturn(null);
		Assertions.assertThrows(HotelNotFoundException.class,
				()->serviceimpl.findbycountrydetails(anyString()));
		
	}
	
	@Test
	final void addhoteldetails() {
		Address address = new Address("Mockcity", "MockCountry");
		Review review =  new Review("Mockuser", 7, true); 
		Review review2 = new Review("MockUser2", 7, true);
		List<Review> reviewlist = Arrays.asList(review,review2);
		Hotel hotel = new Hotel("createMockid","Mockname", 7, address, reviewlist, 12);
		//Hotel hoteldto = new HotelDTO("createMockid","Mockname", 7, address, reviewlist, 12);
		when(hotelRepository.insert(any(Hotel.class))).thenReturn(hotel);
		
		Hotel hoteldetails = serviceimpl.addhoteldetails(hotel);
		
		assertNotNull(hoteldetails);
		
		assertEquals("createMockid", hoteldetails.getId());
		assertEquals("Mockname", hoteldetails.getName());
		assertEquals("7", hoteldetails.getPricePerNight().toString());
		assertEquals("Mockcity", hoteldetails.getAddress().getCity());
		assertEquals("MockCountry", hoteldetails.getAddress().getCountry());	
	}
	
	@Test
	final void updatehoteldetails() {
		
		
		when(hotelRepository.save(any(Hotel.class))).thenReturn(hotel);
		Hotel hoteldetail = serviceimpl.updatehoteldetails(hotel);
		assertNotNull(hoteldetail);
		assertEquals("updateMockid", hoteldetail.getId());
		
	}
	
	
	@Test
	final void deletehoteldetails() {
		Address address = new Address("Mockcity", "MockCountry");
		Review review =  new Review("Mockuser", 7, true); 
		Review review2 = new Review("MockUser2", 7, true);
		List<Review> reviewlist = Arrays.asList(review,review2);
		Hotel hotel = new Hotel("updateMockid","Mockname", 7, address, reviewlist, 12);
		//HotelDTO hotedto= new HotelDTO("updateMockid","Mockname", 7, address, reviewlist, 12);
		hotelRepository.delete(hotel);
		
		serviceimpl.deletehoteldetails(anyString());
		
		assertNotEquals("updatedMockid", hotel.getId());
		
		log.info("value of hotel:::::::::::::::::::::::::::::::::::::::::::::::::"+hotel);
		
		
		
	}
	
	
	
	
	
	
	
}
