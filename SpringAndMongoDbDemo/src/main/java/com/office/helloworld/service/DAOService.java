package com.office.helloworld.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.helloworld.model.Hotel;
import com.office.helloworld.repository.HotelRepository;

@Service
public class DAOService {

	@Autowired HotelRepository hotelRepository;

	public Optional<Hotel> gethotelid(String id) {
		// TODO Auto-generated method stub
		return hotelRepository.findById(id);
	}
	
	
	

	
	
	
}
