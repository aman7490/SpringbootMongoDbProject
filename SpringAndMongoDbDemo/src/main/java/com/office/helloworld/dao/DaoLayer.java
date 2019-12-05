package com.office.helloworld.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.helloworld.model.Hotel;
import com.office.helloworld.repository.HotelRepository;

@Service
public class DaoLayer {

	@Autowired
	HotelRepository hotelRepository;
	
	public Hotel gethoteldetailbyid(String id){
		
		Hotel hotel2= hotelRepository.findByhotelId(id);
		
		return hotel2;
		
	}
	
	
}
