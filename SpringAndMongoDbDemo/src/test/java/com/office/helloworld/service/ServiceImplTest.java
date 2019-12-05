package com.office.helloworld.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.office.helloworld.dto.HotelDTO;
import com.office.helloworld.model.Address;
import com.office.helloworld.model.Hotel;
import com.office.helloworld.model.Review;
import com.office.helloworld.repository.HotelRepository;

class ServiceImplTest {

	@InjectMocks
	ServiceImpl serviceimpl;
	@Mock
	HotelRepository hotelRepository;
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this); // to initiate the object for Service imple we used it.
	}

	@Test
	final void gethoteldetailssbyid() {
		Hotel hotel = new Hotel();
		// address
		Address address = new Address();
		address.setCity("Amritsar - I am a mock value");
		address.setCountry("INDIA- I am a mock value"); 
		// reviews
	//	Review review = new Review("Fakereviews",7,true);
	//	review.setApproved(true);
	//	review.setRating(7);
	//	review.setUsername("Fake reviewer");  */
		
		hotel.setAddress(address);  		
		hotel.setId("Fakeid");
		hotel.setName("Name is Mockito framework");
		
		
	//	hotel.setReviews(review);
	//	hotelRepository.findById("Fakeid");
		
		when(hotelRepository.findByhotelId(anyString())).thenReturn(hotel);
		Hotel hotel3 = hotelRepository.findByhotelId(anyString());
		System.out.println(hotel3);
		//hotelRepository.findByhotelId("Fakeid");
		
			String str = "Fakeid";
			HotelDTO hotel2 = serviceimpl.gethoteldetailssbyid(str);
			assertNotNull(hotel2);
			assertEquals("Fakeid", (hotel2.getId()));
		
	}
}
